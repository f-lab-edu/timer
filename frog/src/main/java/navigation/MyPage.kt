package navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import data.NickFirebase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kr.co.ky.nicknamePackage.NickNameActivity
import kr.co.ky.kozoltime.databinding.FragmentMyPageBinding
import kr.co.ky.nicknamePackage.NickAsync
import kr.co.ky.nicknamePackage.NickDataClass
import kr.co.ky.nicknamePackage.NicknameViewModel


class MyPage : Fragment(){
    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NicknameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyPageBinding.inflate(inflater,container,false)
        val view = binding.root
        viewModel = ViewModelProvider(viewModelStore, ViewModelProvider.NewInstanceFactory())[NicknameViewModel::class.java]
            runBlocking {
                launch {
                    async {
                        viewModel.getNick()
                    }.await()
                    viewModel.nickState.observe(viewLifecycleOwner, Observer {
                        Log.d("뷰모델","!")
                        binding.nickTv.text = it.nickname
                    })
                    Log.d("뷰모델","2")
                }
            }
        viewModel.nickState.value?.let { it.nickname?.let { it1 -> Log.d("뷰모델 값", it1) } }
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
    }
}