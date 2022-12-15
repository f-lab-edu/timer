package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import data.NickCallback
import data.NickFirebase
import kr.co.ky.nicknamePackage.NickNameActivity
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.FragmentDetailBinding

class MyPage : Fragment(){
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val nickFirebase = NickFirebase()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nickBtn.setOnClickListener{
            val intent = Intent(activity, NickNameActivity::class.java)
            startActivity(intent)
        }
        binding.logoutBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
        }
        nickFirebase.sendNickFirebase(object : NickCallback{
            override fun setNickTextView(nick: String?) {
                binding.nickTv.setText(nick)
            }
    })
    }

}