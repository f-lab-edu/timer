package kr.co.ky.community

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.write_community_activity.*
import kr.co.ky.kozoltime.R

class CommunityWriteActivity : AppCompatActivity() {

    val fbAuth = FirebaseAuth.getInstance()
    val fbFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_community_activity)

        community_btn.setOnClickListener{

            val writeData = hashMapOf(
                "id" to fbAuth?.currentUser?.email,
                "title" to community_ssul_title.text.toString(),
                "context" to community_ssul_context.text.toString()
            )
            val bucket = fbFirestore.collection("community")
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }
}