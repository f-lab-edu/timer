package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.FragmentJobEpilogueBinding
import kr.co.ky.office.OfficeActivity

class JobEpilogueFragment : Fragment(){

    private var _binding:FragmentJobEpilogueBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJobEpilogueBinding.inflate(inflater,container,false)
        val view = binding.root
        return view


    }

    override fun onStart() {
        super.onStart()

        binding.officeBtn.setOnClickListener{
            val intent = Intent(activity, OfficeActivity::class.java)
            startActivity(intent)
        }
    }
}