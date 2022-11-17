package kr.co.ky.kozoltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_nick_name.*
import kotlinx.android.synthetic.main.fragment_detail.*
import navigation.DetailViewFragment

class NickNameActivity : AppCompatActivity() {

    var fbAuth = FirebaseAuth.getInstance()
    var fbFirestore = FirebaseFirestore.getInstance()
    var nickInfo = NickNameDataClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)

        nick_set_btn.setOnClickListener{
            val edit = nick_edit.text.toString()
            nickInfo.emailId = fbAuth?.currentUser?.email
            nickInfo.nickname = edit

            bringNick(nickInfo.nickname)
            val writeData = hashMapOf(
                "eamilId" to nickInfo.emailId,
                "nickname" to nickInfo.nickname,
            )
            val bucket = fbFirestore.collection("nickname")
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this,"데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
        }
        }
    fun bringNick(inputNick:String?){
        val bundle = Bundle()
        bundle.putString("nickname",inputNick)
        val fragment_detail = DetailViewFragment()
        fragment_detail.setArguments(bundle)
        val manager:FragmentManager = getSupportFragmentManager()
        val transaction : FragmentTransaction = manager.beginTransaction()
//        transaction.replace(R.id.frame_nick, DetailViewFragment()).commit()
    }
    }
