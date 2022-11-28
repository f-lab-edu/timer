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
import kotlinx.android.synthetic.main.activity_login_join.*
import kotlinx.android.synthetic.main.activity_login_join.google_button
import kr.co.ky.kozoltime.MainActivity
import kr.co.ky.kozoltime.R

class LoginJoinActivity : AppCompatActivity() {
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var googleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_join)
        login_btn.setOnClickListener {
            if (id_edit.length() == 0 && password_edit.length() == 0) {
                detectEmailAndPasswordEmpty()
            } else {
                signinAndSignup()
            }
        }
        google_button.setOnClickListener {
            googleLogin()
        }
        join_btn.setOnClickListener {
            if (id_edit.length() == 0 && password_edit.length() == 0) {
                detectEmailAndPasswordEmpty()
            } else {
                signinEmail()
            }
        }
        just_look_btn.setOnClickListener {
            guestMoveMainPage()
        }
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    fun googleLogin() {
        var signInIntent = googleSignInClient?.signInIntent
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
        auth?.signInWithCredential(credential)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    moveMainPage(task.result?.user)
                } else {
                    Toast.makeText(this, "회원가입을 해주세요.", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun signinAndSignup() {
        auth?.signInWithEmailAndPassword(
            id_edit.text.toString(),
            password_edit.text.toString()
        )?.addOnCompleteListener { task ->
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
        auth?.createUserWithEmailAndPassword(
            id_edit.text.toString(),
            password_edit.text.toString()
        )?.addOnCompleteListener { task ->
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
        login_btn.isEnabled = false
        join_btn.isEnabled = false

        id_edit.addTextChangedListener {
            val email = id_edit.text.toString()
            val password = password_edit.text.toString()
            var enabled = email.isNotEmpty() && password.isNotEmpty()
            login_btn.isEnabled = enabled
            join_btn.isEnabled = enabled
        }

        password_edit.addTextChangedListener {
            val email = id_edit.text.toString()
            val password = password_edit.text.toString()
            var enabled = email.isNotEmpty() && password.isNotEmpty()
            login_btn.isEnabled = enabled
            join_btn.isEnabled = enabled
        }
    }
}
