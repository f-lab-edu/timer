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
import kr.co.ky.search.SearchActivity

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
        binding.homeSearchBtn.setOnClickListener{
            val intentSearch = Intent(activity, SearchActivity::class.java)
            startActivity(intentSearch)
        }
        binding.factoryButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","사무직")
            startActivity(intentOffice)
        }
        binding.establishmentButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","창업")
            startActivity(intentOffice)
        }
        binding.sportsButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","운동선수")
            startActivity(intentOffice)
        }
        binding.serviceButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","서비스업")
            startActivity(intentOffice)
        }
        binding.clericButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","성직자")
            startActivity(intentOffice)
        }
        binding.publicButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","공무원")
            startActivity(intentOffice)
        }
        binding.itButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","it 개발자")
            startActivity(intentOffice)
        }
        binding.influencerButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","인플루언서")
            startActivity(intentOffice)
        }
        binding.nurceButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","간호조무사")
            startActivity(intentOffice)
        }
        binding.deliveryButton.setOnClickListener{
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path","배달부")
            startActivity(intentOffice)
        }
        binding.ectButton.setOnClickListener {
            val intentOffice = Intent(activity, OfficeActivity::class.java)
            intentOffice.putExtra("path", "기타등등")
            startActivity(intentOffice)
        }
    }
}