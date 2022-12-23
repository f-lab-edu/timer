package kr.co.ky.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import data.DetailFirebase
import data.DetailListener
import data.NickCallback
import data.NickFirebase
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.ActivityDetailBinding
import kr.co.ky.kozoltime.databinding.DetailCardviewBinding
import java.text.SimpleDateFormat
import java.util.*

class DetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var userNickname: String? = null
    private val dateformat = SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val receivedIntent = getIntent()
        val page = receivedIntent.getStringExtra("page")
        val documentFromAdapter = receivedIntent.getStringExtra("document")

        if (page != null && documentFromAdapter != null) {
            DetailFirebase().receiveDetailFirebase(page, documentFromAdapter, object : DetailListener {
                override fun detail(mutableDetailList: MutableList<CommunityDataClass.Comment>) {
                    binding.detailPageChatRecyclerview.layoutManager = LinearLayoutManager(binding.detailPageChatRecyclerview.context)
                    binding.detailPageChatRecyclerview.adapter = DetailAdapter(mutableDetailList)
                    (binding.detailPageChatRecyclerview.adapter as DetailAdapter).notifyDataSetChanged()
                }
            })
        } else {
            Toast.makeText(this,"정보를 불러오는 데 실패하였습니다.",Toast.LENGTH_SHORT).show()
        }

        binding.chatButton.setOnClickListener {
            if (page != null && documentFromAdapter != null) {
                DetailFirebase().sendDetailFirebase(binding.detailPageChatEditText.text.toString(),page,documentFromAdapter)
            }
        }
    }
}
