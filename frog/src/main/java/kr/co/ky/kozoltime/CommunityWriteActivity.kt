package kr.co.ky.kozoltime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.write_community_activity.*

class CommunityWriteActivity : AppCompatActivity() {

    var fbAuth = FirebaseAuth.getInstance()
    var fbFirestore = FirebaseFirestore.getInstance()
    var communityInfo = CommunityDataClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_community_activity)

        community_btn.setOnClickListener{

            communityInfo.id = fbAuth?.currentUser?.email
            communityInfo.title = community_ssul_title.text.toString()
            communityInfo.context = community_ssul_context.text.toString()

            val writeData = hashMapOf(
                "id" to communityInfo.id,
                "title" to communityInfo.title,
                "context" to communityInfo.context
            )
            val bucket = fbFirestore.collection("community")
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this,"데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
        }
    }
}