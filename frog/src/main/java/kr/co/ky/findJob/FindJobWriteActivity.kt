package kr.co.ky.findJob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.ActivityFindJobWriteBinding
import java.text.SimpleDateFormat
import java.util.*

class FindJobWriteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFindJobWriteBinding
    val dateformat = SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
    private val fbFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindJobWriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.findJobWriteButton.setOnClickListener{
            val fileName = dateformat.format(Date())

            val jobWriteData = FindJobDataClass(
                title = binding.findJobWriteTitle.text.toString(),
                date = fileName,
                officeName = binding.findJobWriteOfficeName.text.toString(),
                context = binding.findJobWriteContext.text.toString()
            )
            val bucket = fbFirestore.collection(getString(R.string.findJobKey))
            bucket.document(fileName).set(jobWriteData).addOnSuccessListener {
                Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener {
                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
