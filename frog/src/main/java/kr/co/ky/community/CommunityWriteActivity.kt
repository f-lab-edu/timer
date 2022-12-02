package kr.co.ky.community

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.write_community_activity.*
import kr.co.ky.kozoltime.R
import java.text.SimpleDateFormat
import java.util.*

class CommunityWriteActivity : AppCompatActivity() {

    val fbAuth = FirebaseAuth.getInstance()
    val fbFirestore = FirebaseFirestore.getInstance()
    val storage : FirebaseStorage = FirebaseStorage.getInstance()
    var imageRef = storage.reference.child("images/")
    var uri: Uri? = null
    val laucher = registerForActivityResult(ActivityResultContracts.GetContent()) { it ->
        uri = it
        community_ssul_image.setImageURI(uri)
        Log.e("text", uri.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_community_activity)

        ssul_spinner.adapter = ArrayAdapter.createFromResource(this,R.array.itemList,android.R.layout.simple_spinner_item)
        ssul_spinner.prompt= getString(R.string.job_select)

        community_ssul_image.setOnClickListener {
            laucher.launch("images/*")
        }
        community_btn.setOnClickListener{
            val fileName = "${SimpleDateFormat("yyyymmdd_HHmm").format(Date())}_${fbAuth.currentUser?.email}"
            if(uri != null) {
                imageRef.putFile(uri!!).continueWithTask{ task: Task<UploadTask.TaskSnapshot> ->
                    return@continueWithTask imageRef.downloadUrl
                }.addOnSuccessListener {
                    val communityDataClass = CommunityDataClass()
                    communityDataClass.imageUri = it.toString()
                    communityDataClass.context = community_ssul_context.text.toString()
                    communityDataClass.title = community_ssul_title.text.toString()
                    communityDataClass.id = fbAuth.currentUser?.email
                    communityDataClass.timestamp = System.currentTimeMillis()

                    fbFirestore.collection("community").document(fileName).set(communityDataClass)
                    finish()
                    Toast.makeText(this, "서버로 데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this,"이미지를 부르는데 실패하였습니다.",Toast.LENGTH_SHORT).show()
                }


            } else {
                val writeData = hashMapOf(
                    "id" to fbAuth.currentUser?.email,
                    "title" to community_ssul_title.text.toString(),
                    "context" to community_ssul_context.text.toString(),
                    "timestamp" to System.currentTimeMillis()
                )
                val bucket = fbFirestore.collection("community")
                bucket.document(fileName).set(writeData).addOnSuccessListener {
                    Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                }
                    .addOnFailureListener {
                        Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

}



