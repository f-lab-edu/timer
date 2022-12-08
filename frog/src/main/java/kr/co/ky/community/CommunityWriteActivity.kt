package kr.co.ky.community

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
    val storage: FirebaseStorage = FirebaseStorage.getInstance()
    var firebaseUri: Uri? = null
    var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            it.data?.data?.let { uri ->
                firebaseUri = uri
                community_ssul_image.setImageURI(uri)
                contentResolver.takePersistableUriPermission(uri, FLAG_GRANT_READ_URI_PERMISSION)
                Log.e("text", uri.toString())
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_community_activity)

        ssul_spinner.adapter = ArrayAdapter.createFromResource(this,
            R.array.itemList,
            android.R.layout.simple_spinner_item)
        ssul_spinner.prompt = getString(R.string.job_select)

        community_ssul_image.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.type = "image/*"
                    launcher.launch(intent)

                }
                    shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                        showPermissionContextPopup()
                    }
                    else -> {
                        requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                            1000)
                    }
            }
            community_btn.setOnClickListener {
                if (firebaseUri != null) {
                    val fileName = "IMAGE_${SingleDate.invoke()}_.png"
                    val imageRef = storage.reference.child("image/").child(fileName)
                    imageRef.putFile(firebaseUri!!)
                        .continueWithTask { task: Task<UploadTask.TaskSnapshot> ->
                            return@continueWithTask imageRef.downloadUrl
                        }.addOnSuccessListener {
                            val communityDataClass = CommunityDataClass(
                                title = community_ssul_title.text.toString(),
                                context = community_ssul_context.text.toString(),
                                id = fbAuth.currentUser?.email,
                                uid = fbAuth.currentUser?.uid,
                                imageUri = it.toString(),
                                timestamp = System.currentTimeMillis(),
                                document = fileName
                            )

                            fbFirestore.collection("community").document(fileName)
                                .set(communityDataClass)
                            finish()
                            Toast.makeText(this, "서버로 데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                        }.addOnFailureListener {
                            Toast.makeText(this, "이미지를 부르는데 실패하였습니다.", Toast.LENGTH_SHORT).show()
                        }


                } else {
                    val writeData = hashMapOf(
                        "id" to fbAuth.currentUser?.email,
                        "title" to community_ssul_title.text.toString(),
                        "context" to community_ssul_context.text.toString(),
                        "timestamp" to System.currentTimeMillis()
                    )
                    val bucket = fbFirestore.collection("community")
                    bucket.document().set(writeData).addOnSuccessListener {
                        Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                        .addOnFailureListener {
                            Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
        private fun showPermissionContextPopup() {
            AlertDialog.Builder(this)
                .setTitle("권한이 필요합니다.")
                .setMessage("사진을 불러오기 위해서 권한이 필요합니다.")
                .setPositiveButton("동의") { _, _ ->
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                        1000)
                }
                .setNegativeButton("취소") { _, _ -> }
                .create()
                .show()
        }
}
