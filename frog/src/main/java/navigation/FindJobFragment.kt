package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import data.FindJobFirebase
import data.FindJobListener
import kr.co.ky.findJob.FindJobAdapter
import kr.co.ky.findJob.FindJobDataClass
import kr.co.ky.findJob.FindJobWriteActivity
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.FragmentFindJobBinding
import kr.co.ky.search.SearchActivity

class FindJobFragment : Fragment(){
    private var _binding: FragmentFindJobBinding? = null
    private val binding get() = _binding!!
    val findJobFirebase = FindJobFirebase()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindJobBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabWriteFindJob.setOnClickListener{
            val intentSearch = Intent(context, FindJobWriteActivity::class.java)
            startActivity(intentSearch)
        }
        binding.findJobRecyclerview.layoutManager = LinearLayoutManager(activity)

        findJobFirebase.getFindJob(object : FindJobListener{
            override fun getJobList(jobList: MutableList<FindJobDataClass>) {
                binding.findJobRecyclerview.adapter = FindJobAdapter(jobList)
                (binding.findJobRecyclerview.adapter as FindJobAdapter).notifyDataSetChanged()
            }
        })
    }
}