package navigation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import data.DataListener
import data.FirebaseData
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.community.CommunityWriteActivity
import kr.co.ky.kozoltime.*
import kr.co.ky.kozoltime.databinding.FragmentCommunityBinding
import kr.co.ky.like.Like


class CommunityFragment : Fragment(){
    private val firebaseData = FirebaseData()
    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val path = "community"
        binding.communityRv.layoutManager = LinearLayoutManager(activity)

        firebaseData.receiveFirebase(path, object : DataListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun adapter(mutableList: MutableList<CommunityDataClass>) {
                val like = Like()
                binding.communityRv.adapter = CommunityAdapter(mutableList,path,like)
                (binding.communityRv.adapter as CommunityAdapter).notifyDataSetChanged()

            }
        })

        binding.fabWriteCommunity.setOnClickListener{
            val intent = Intent(context, CommunityWriteActivity::class.java)
            startActivity(intent)
        }
    }

}
