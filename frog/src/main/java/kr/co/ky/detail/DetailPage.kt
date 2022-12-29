package kr.co.ky.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import data.*
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.databinding.ActivityDetailBinding
import kr.co.ky.nicknamePackage.NicknameViewModel
import kr.co.ky.nicknamePackage.ViewModelFactory

class DetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: NicknameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val receivedIntent = getIntent()
        val page = receivedIntent.getStringExtra("page")
        val documentFromAdapter = receivedIntent.getStringExtra("document")

        if (page != null && documentFromAdapter != null) {
            DetailFirebase().receiveDetailFirebase(page,
                documentFromAdapter,
                object : DetailListener {
                    override fun detail(mutableDetailList: MutableList<CommunityDataClass.Comment>) {
                        binding.detailPageChatRecyclerview.layoutManager =
                            LinearLayoutManager(binding.detailPageChatRecyclerview.context)
                        binding.detailPageChatRecyclerview.adapter =
                            DetailAdapter(mutableDetailList)
                        (binding.detailPageChatRecyclerview.adapter as DetailAdapter).notifyDataSetChanged()
                    }
                })
        } else {
            Toast.makeText(this, "정보를 불러오는 데 실패하였습니다.", Toast.LENGTH_SHORT).show()
        }

        binding.chatButton.setOnClickListener {
            viewModel = ViewModelProvider(viewModelStore, ViewModelFactory()).get(NicknameViewModel::class.java)
            viewModel.nickState.observe(this, Observer {
                if (page != null && documentFromAdapter != null) {
                    DetailFirebase().receiveDetailFirebase(page,
                        documentFromAdapter,
                        object : DetailListener{
                            override fun detail(mutableDetailList: MutableList<CommunityDataClass.Comment>) {
                                it.nickname?.let { it1 ->
                                    DetailFirebase().setDetailview(binding.detailPageChatEditText.text.toString(),
                                        it1,
                                        page,
                                        documentFromAdapter)
                                }
                        }
                        })
                }
            })
        }
    }
}


