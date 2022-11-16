package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    var fbAuth = FirebaseAuth.getInstance()
    var fbFirestore = FirebaseFirestore.getInstance()
    var postInfo = Post()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        write_spinner.adapter = ArrayAdapter.createFromResource(this,R.array.itemList,android.R.layout.simple_spinner_item)
        write_spinner.prompt="직종을 선택해주세요."

        write_btn.setOnClickListener{

            postInfo.id = fbAuth?.currentUser?.email
            postInfo.title = write_ssul_title.text.toString()
            postInfo.context = write_ssul_context.text.toString()

            val writeData = hashMapOf(
                "id" to postInfo.id,
                "title" to postInfo.title,
                "context" to postInfo.context
            )
            val bucket = fbFirestore.collection("kozoltime")
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this,"데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.",Toast.LENGTH_SHORT).show()
                }
        }
    }
}