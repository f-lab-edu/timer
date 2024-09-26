package kr.co.ky.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.storage.FirebaseStorage
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.kozoltime.MainActivity
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.ActivityLoginJoinBinding

class LoginJoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginJoinBinding
    var auth = FirestoreKey.auth
    var googleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginJoinBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginBtn.setOnClickListener {
            if (binding.idEdit.length() == 0 && binding.passwordEdit.length() == 0) {
                detectEmailAndPasswordEmpty()
            } else {
                signinAndSignup()
            }
        }
        binding.googleButton.setOnClickListener {
            googleLogin()
        }
        binding.joinBtn.setOnClickListener {
            if (binding.idEdit.length() == 0 && binding.passwordEdit.length() == 0) {
                detectEmailAndPasswordEmpty()
            } else {
                signinEmail()
            }
        }
        binding.justLookBtn.setOnClickListener {
            guestMoveMainPage()
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

    }

    fun googleLogin() {
        val signInIntent = googleSignInClient?.signInIntent
        startForResult.launch(signInIntent)
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

            if (result.resultCode == RESULT_OK) {
                val intent: Intent = result.data!!
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(intent)
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account)
                } catch (e: ApiException) {
                    Log.w(ContentValues.TAG, "Google sign in failed", e)
                }
            }
        }

    fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        var credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    moveMainPage(task.result?.user)
                } else {
                    Toast.makeText(this, "회원가입을 해주세요.", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun signinAndSignup() {
        auth.signInWithEmailAndPassword(
            binding.idEdit.text.toString(),
            binding.passwordEdit.text.toString()
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                moveMainPage(task.result?.user)
            } else if (task.exception?.message.isNullOrEmpty()) {
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
            } else {
    //                signinEmail()
            }
        }
    }

    fun signinEmail() {
        auth.createUserWithEmailAndPassword(
            binding.idEdit.text.toString(),
            binding.passwordEdit.text.toString()
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                moveMainPage(task.result?.user)
            } else {
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun moveMainPage(user: FirebaseUser?) {

        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "회원가입을 하세요", Toast.LENGTH_LONG).show()
            detectEmailAndPasswordEmpty()
        }

    }

    fun guestMoveMainPage() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun detectEmailAndPasswordEmpty() {
        binding.loginBtn.isEnabled = false
        binding.joinBtn.isEnabled = false

        binding.idEdit.addTextChangedListener {
            val email = binding.idEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            val enabled = email.isNotEmpty() && password.isNotEmpty()
            binding.loginBtn.isEnabled = enabled
            binding.joinBtn.isEnabled = enabled
        }

        binding.passwordEdit.addTextChangedListener {
            val email = binding.idEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            val enabled = email.isNotEmpty() && password.isNotEmpty()
            binding.loginBtn.isEnabled = enabled
            binding.joinBtn.isEnabled = enabled
        }
    }
}
