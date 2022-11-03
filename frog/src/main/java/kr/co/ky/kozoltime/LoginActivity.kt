package kr.co.ky.kozoltime

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    var googleSignInClient : GoogleSignInClient? = null
    //구글 로그인 할 때사용할 리퀘스트코드만들기
    var GOOGLE_LOGIN_CODE = 9001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        email_login_button.setOnClickListener{
            signinAndSignup()
        }
        google_sign_in_button.setOnClickListener{
            //첫번째 단계
            googleLogin()
        }
        //구글 로그인 옵션 만들
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            . requestEmail() //이메일 아이디 받아오기
            .build()
        //옵션값을 googlesignInClient 에 세팅
        googleSignInClient = GoogleSignIn.getClient(this,gso)
    }
    fun googleLogin(){
        //구글 사용자인지 구글 플랫폼에 요청
        var signInIntent = googleSignInClient?.signInIntent
        startForResult.launch(signInIntent)
    }

   private val startForResult =
       registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
           result: ActivityResult ->

           if (result.resultCode == RESULT_OK){
               val intent: Intent = result.data!!
               //구글 로그인에 성공했을 때 넘어오는 토큰 값을 받습니다.
               val task: Task<GoogleSignInAccount> =
                   GoogleSignIn.getSignedInAccountFromIntent(intent)
               try {
                   //APIException Casting
                   val account = task.getResult(ApiException::class.java)!!
                   Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:"+account.id)
                   // 두번째 단계
                   firebaseAuthWithGoogle(account)
            }catch (e: ApiException){
                Log.w(ContentValues.TAG, "Google sign in failed",e)
            }
        }
    }
    fun firebaseAuthWithGoogle(account: GoogleSignInAccount?){
        // 구글 로그인에 성공했다는 인증서
        var credential = GoogleAuthProvider.getCredential(account?.idToken,null)
        //로그인 시도
        auth?.signInWithCredential(credential)
                // 성공 유무의 값 확인
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //Login
                    moveMainPage(task.result?.user)
                } else {
                    //Show the error message
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }
    fun signinAndSignup() {
        // 회원가입
        auth?.createUserWithEmailAndPassword(
            email_edittext.text.toString(),
            password_edittext.text.toString()
        )?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                //Creating a user account
                moveMainPage(task.result?.user)
            } else if (task.exception?.message.isNullOrEmpty()) {
                //Show the error message
                Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
            } else {
                //Login if you have account
                signinEmail()
            }
        }
    }
        fun signinEmail() {
            auth?.createUserWithEmailAndPassword(
                email_edittext.text.toString(),
                password_edittext.text.toString()
            )?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //Login
                    moveMainPage(task.result?.user)
                } else {
                    //Show the error message
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
                }
            }
        }
        fun moveMainPage(user: FirebaseUser?){
            if(user != null){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }

}