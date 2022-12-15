package kr.co.ky.office

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import data.DataListener
import data.FirebaseData
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.WriteActivity
import kr.co.ky.kozoltime.databinding.ActivityOfficeBinding
import kr.co.ky.like.Like

class OfficeActivity : AppCompatActivity() {

        private lateinit var binding: ActivityOfficeBinding
        private val firebaseData = FirebaseData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfficeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fabWrite.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
        val path = "kozoltime"
        binding.officeRv.layoutManager = LinearLayoutManager(this@OfficeActivity)

        firebaseData.receiveFirebase(path, object : DataListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun adapter(mutableList: MutableList<CommunityDataClass>) {
                val like =  Like()
                binding.officeRv.adapter = CommunityAdapter(mutableList,path,like)
                (binding.officeRv.adapter as CommunityAdapter).notifyDataSetChanged()

            }
        })
    }
}
