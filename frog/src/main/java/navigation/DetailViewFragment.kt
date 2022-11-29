package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import data.NickCallback
import data.NickDataClass
import data.NickFirebase
import kotlinx.android.synthetic.main.fragment_detail.*
import kr.co.ky.nicknamePackage.NickNameActivity
import kr.co.ky.kozoltime.R

class DetailViewFragment : Fragment(){
    private val nickFirebase = NickFirebase()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_detail,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nick_btn.setOnClickListener{
            val intent = Intent(activity, NickNameActivity::class.java)
            startActivity(intent)
        }
        logout_btn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
        }
        nickFirebase.sendNickFirebase(object : NickCallback{
            override fun setNickTextView(nick: String?) {
                nick_tv.setText(nick)
            }
    })

        var message = this.arguments?.getString("nickname")

        nick_tv.text = message
    }

}