package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()
    private val fbFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        write_spinner.adapter = ArrayAdapter.createFromResource(this,R.array.itemList,android.R.layout.simple_spinner_item)
        write_spinner.prompt= getString(R.string.job_select)

        write_btn.setOnClickListener{

            val writeData = hashMapOf(
                "id" to fbAuth.currentUser?.email,
                "title" to write_ssul_title.text.toString(),
                "context" to write_ssul_context.text.toString()
            )
            val kozoltime = "kozoltime"
            val bucket = fbFirestore.collection(kozoltime)
            bucket.add(writeData).addOnSuccessListener {
                Toast.makeText(this,"데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.",Toast.LENGTH_SHORT).show()
                }
        }
    }
}