package kr.co.ky.office

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import data.DataListener
import data.FirebaseData
import kr.co.ky.cardviewCollection.CardviewCollection
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
        val pathIntent = intent
        val path = pathIntent.getStringExtra("path")
        binding.officeRv.layoutManager = LinearLayoutManager(this@OfficeActivity)

        if (path != null) {
            firebaseData.receiveFirebase(path, object : DataListener() {
                @SuppressLint("NotifyDataSetChanged")
                override fun adapter(mutableList: MutableList<CommunityDataClass>) {
                    val like =  Like()
                    val cardviewCollection = CardviewCollection()
                    binding.officeRv.adapter = CommunityAdapter(mutableList,path,like,cardviewCollection)
                    (binding.officeRv.adapter as CommunityAdapter).notifyDataSetChanged()

                }
            })
        }
    }
}
