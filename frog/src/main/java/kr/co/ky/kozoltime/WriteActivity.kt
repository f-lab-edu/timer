package kr.co.ky.kozoltime

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
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
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.kozoltime.databinding.ActivityWriteBinding
import kr.co.ky.office.OfficeActivity
import java.text.SimpleDateFormat
import java.util.*

class WriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWriteBinding
    private val fbAuth = FirestoreKey.auth
    private val fbFirestore = FirebaseFirestore.getInstance()
    var firebaseUri: Uri? = null
    val collection = "office"
    val dateformat = SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
    lateinit var writeSpinner:String
    var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            it.data?.data?.let { uri ->
                firebaseUri = uri
                binding.jobWriteImage.setImageURI(uri)
                Log.e("text", uri.toString())
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.writeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.itemList,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.writeSpinner.adapter = adapter
        }
        binding.writeSpinner.prompt = getString(R.string.job_select)

        binding.writeSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent : AdapterView<*>, view : View, position : Int, id : Long){
                writeSpinner = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent : AdapterView<*> ){}
        })
        binding.jobWriteImage.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                    val intentImage = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intentImage.type = "image/*"
                    launcher.launch(intentImage)

                }
                ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED -> {
                    showPermissionContextPopup()
                }
            }
        }
            binding.jobWriteBtn.setOnClickListener {
                val fileName = dateformat.format(Date())
                if(firebaseUri != null) {
                    val imageRef = Firebase.storage.reference.child("image/").child(fileName)
                    imageRef.putFile(firebaseUri!!)
                        .continueWithTask { task: Task<UploadTask.TaskSnapshot> ->
                            return@continueWithTask imageRef.downloadUrl
                        }.addOnSuccessListener {
                            val communityDataClass = CommunityDataClass(
                                title = binding.jobWriteTitle.text.toString(),
                                context = binding.jobWriteContext.text.toString(),
                                id = fbAuth.currentUser?.email,
                                uid = fbAuth.currentUser?.uid,
                                imageUri = it.toString(),
                                singleDate = fileName,
                                document = fileName,

                            )
                            val bucket = fbFirestore.collection(writeSpinner).document(fileName)
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
                        "title" to binding.jobWriteTitle.text.toString(),
                        "context" to binding.jobWriteContext.text.toString(),
                        "uid" to fbAuth.currentUser?.uid,
                        "singleDate" to fileName,
                        "document" to fileName

                    )
                    val bucket = fbFirestore.collection(writeSpinner)
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
    private fun SettingPopup() {
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다.")
            .setMessage("사진 권한을 불러오기 위해 환경설정으로 이동합니다. 이미지를 사용하려면 권한에 동의해주세요.")
            .setPositiveButton("동의") { _, _ ->
                val intentPermission = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intentPermission.data = Uri.parse(("package:" + this.packageName))
                this.startActivity(intentPermission)
            }
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
                    val intentImage = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intentImage.type = "image/*"
                    launcher.launch(intentImage)
                } else {
                    Toast.makeText(this, "권한을 거부했습니다.", Toast.LENGTH_SHORT).show()
                    SettingPopup()
                }
            }
            else -> {
                Log.d("권한", "종료")
                showPermissionContextPopup()
            }
        }
    }
}