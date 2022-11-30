package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*
import kr.co.ky.nicknamePackage.NickNameActivity
import kr.co.ky.kozoltime.R

class DetailViewFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_detail,container,false)
        return view
    }

    override fun onStart() {
        super.onStart()

        nick_btn.setOnClickListener{
            val intent = Intent(activity, NickNameActivity::class.java)
            startActivity(intent)
        }
        var message = this.arguments?.getString("nickname")

        nick_tv.text = message
    }
}