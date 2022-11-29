package kr.co.ky.office

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import data.DataListener
import data.FirebaseData
import kotlinx.android.synthetic.main.activity_office.*
import kotlinx.android.synthetic.main.fragment_community.*
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.WriteActivity

class OfficeActivity : AppCompatActivity() {
        private val firebaseData = FirebaseData()
        lateinit var officeAdapter: CommunityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_office)

        fabWrite.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
        val path = "kozoltime"
        firebaseData.communityFirebase(path, object : DataListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun adapter(mutableList: MutableList<CommunityDataClass>) {

                office_rv.adapter = CommunityAdapter(mutableList)
                officeAdapter = CommunityAdapter(mutableList)
                (office_rv.adapter as CommunityAdapter).notifyDataSetChanged()
                office_rv.layoutManager = LinearLayoutManager(this@OfficeActivity)

            }
        })
    }
}
