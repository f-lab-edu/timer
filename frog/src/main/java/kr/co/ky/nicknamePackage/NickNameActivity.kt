package kr.co.ky.nicknamePackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_nick_name.*
import kr.co.ky.kozoltime.R
import navigation.DetailViewFragment

class NickNameActivity : AppCompatActivity() {

    val fbAuth = FirebaseAuth.getInstance()
    val fbFirestore = FirebaseFirestore.getInstance()
    val databaseReference = FirebaseDatabase.getInstance().getReference()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)

        nick_set_btn.setOnClickListener{
            bringNick(nick_edit.text.toString())
            val writeData = hashMapOf(
                "eamilId" to fbAuth?.currentUser?.email,
                "kr/co/ky/nicknamePackage" to nick_edit.text.toString()
            )
            val bucket = fbFirestore.collection("kr/co/ky/nicknamePackage")
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this,"데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
        }
        nick_overlap_btn.setOnClickListener{
            nickOverlap()
        }
        }
    fun bringNick(inputNick:String?){
        val bundle = Bundle()
        bundle.putString("kr/co/ky/nicknamePackage",inputNick)
        val fragment_detail = DetailViewFragment()
        fragment_detail.setArguments(bundle)
        val manager:FragmentManager = getSupportFragmentManager()
        val transaction : FragmentTransaction = manager.beginTransaction()
//         transaction.replace(R.id.nick_frame, DetailViewFragment()).commit()
    }
    fun nickOverlap(){
        databaseReference.child("kr/co/ky/nicknamePackage").orderByChild("kr/co/ky/nicknamePackage").equalTo(nick_edit.text.toString())
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if(!dataSnapshot.exists()){
                        Toast.makeText(applicationContext,"사용하셔도 되는 닉네임입니다.",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext,"중복된 닉네임입니다.",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(dataError: DatabaseError) {
                    Toast.makeText(applicationContext,"중복 검사에 실패 하셨습니다.",Toast.LENGTH_SHORT).show()
                }
            })
    }
    }
