package kr.co.ky.nicknamePackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_login_join.*
import kotlinx.android.synthetic.main.activity_nick_name.*
import kr.co.ky.kozoltime.R
import navigation.DetailViewFragment

class NickNameActivity : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()
    private val fbFirestore = FirebaseFirestore.getInstance()
    private val emailId = "emailId"
    private val nickname = "nickname"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)

        nick_set_btn.setOnClickListener {
            val writeData = hashMapOf(
                emailId to fbAuth.currentUser?.email,
                nickname to nick_edit.text.toString()
            )
            val bucket = fbFirestore.collection(nickname)
            val email = fbAuth.currentUser?.email

            if(email != null) {
                bucket.document(email).set(writeData).addOnSuccessListener {
                    Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                }
                    .addOnFailureListener {
                        Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                    }
            } else{
                Toast.makeText(this, "아이디 입력 또는 회원 가입을 해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
        nick_overlap_btn.setOnClickListener {
            nickOverlap()
        }
    }


    fun nickOverlap() {
        fbFirestore.collection(nickname)
            .whereEqualTo(nickname,nick_edit.text.toString())
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    for (documnet in documents) {
                        Toast.makeText(this, "중복된 닉네임 입니다.", Toast.LENGTH_SHORT).show()
                        detectBtn(nick_edit.text.toString())
                    }
                }else {
                    Toast.makeText(this,"사용하셔도 되는 닉네임입니다.",Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "잘못된 닉네임입니다.", Toast.LENGTH_SHORT).show()
            }
    }

    private fun detectBtn(firstNick:String) {
        nick_set_btn.isEnabled = false
        nick_overlap_btn.isEnabled = false

        nick_edit.addTextChangedListener {
            val nick = nick_edit.text.toString()
            var enabled = nick !=firstNick
            var notEnabled = nick == firstNick

            if(enabled){
                nick_set_btn.isEnabled = enabled
                nick_overlap_btn.isEnabled = enabled
            } else if(notEnabled) {
                nick_set_btn.isEnabled = false
                nick_overlap_btn.isEnabled = false
            }

        }
    }
}