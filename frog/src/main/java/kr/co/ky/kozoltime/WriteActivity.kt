package kr.co.ky.kozoltime

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.write_community_activity.*
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.office.OfficeActivity
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {

    private val fbAuth = FirestoreKey.auth
    private val fbFirestore = FirebaseFirestore.getInstance()
    var firebaseUri: Uri? = null
    val collection = "kozoltime"
    val dateformat = SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
    lateinit var writeSpinner:String
    var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            it.data?.data?.let { uri ->
                firebaseUri = uri
                job_write_image.setImageURI(uri)
                Log.e("text", uri.toString())
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        write_spinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.itemList,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            write_spinner.adapter = adapter
        }
        write_spinner.prompt = getString(R.string.job_select)

        write_spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent : AdapterView<*>, view : View, position : Int, id : Long){
                writeSpinner = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent : AdapterView<*> ){}
        })
        job_write_image.setOnClickListener {
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
        }
            job_write_btn.setOnClickListener {
                val fileName = dateformat.format(Date())
                if(firebaseUri != null) {
                    val imageRef = Firebase.storage.reference.child("image/").child(fileName)
                    imageRef.putFile(firebaseUri!!)
                        .continueWithTask { task: Task<UploadTask.TaskSnapshot> ->
                            return@continueWithTask imageRef.downloadUrl
                        }.addOnSuccessListener {
                            val communityDataClass = CommunityDataClass(
                                title = job_write_title.text.toString(),
                                context = job_write_context.text.toString(),
                                id = fbAuth.currentUser?.email,
                                uid = fbAuth.currentUser?.uid,
                                imageUri = it.toString(),
                                singleDate = fileName,
                                document = fileName,
                                spinner = writeSpinner
                            )
                            val bucket = fbFirestore.collection(collection).document(fileName)
                            bucket.set(communityDataClass).addOnSuccessListener {
                                Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                            }
                                .addOnFailureListener {
                                    Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT)
                                        .show()
                                }
                        }
                } else{
                    val writeData = hashMapOf(
                        "id" to fbAuth.currentUser?.email,
                        "title" to job_write_title.text.toString(),
                        "context" to job_write_context.text.toString(),
                        "uid" to fbAuth.currentUser?.uid,
                        "singleDate" to fileName,
                        "document" to fileName
                    )
                    val bucket = fbFirestore.collection(collection)
                    bucket.document(fileName).set(writeData).addOnSuccessListener {
                        Toast.makeText(this, "데이터가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                        .addOnFailureListener {
                            Toast.makeText(this, "데이터 추가에 실패하셨습니다.", Toast.LENGTH_SHORT).show()
                        }
                }
                val intent = Intent(this, OfficeActivity::class.java)
                startActivity(intent)
            }
        }

        fun showPermissionContextPopup() {
            AlertDialog.Builder(this)
                .setTitle("권한이 필요합니다.")
                .setMessage("사진을 불러오기 위해서 권한이 필요합니다.")
                .setPositiveButton("동의") { _, _ ->
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                    intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.type = "image/*"
                    launcher.launch(intent)}
                .setNegativeButton("취소") { _, _ -> }
                .create()
                .show()
        }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1000 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.type = "image/*"
                    launcher.launch(intent)
                } else {
                    // 거부 클릭시
                    Toast.makeText(this, "권한을 거부했습니다.", Toast.LENGTH_SHORT).show()
                    showPermissionContextPopup()
                }
            }
            else -> {
                Log.d("권한", "종료")
                showPermissionContextPopup()
            }
        }
    }
}