package navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_community.*
import kotlinx.android.synthetic.main.write_community_activity.*
import kr.co.ky.kozoltime.CommunityAdapter
import kr.co.ky.kozoltime.CommunityWriteActivity
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.WriteActivity

class CommunityFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_community,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        community_rv.adapter = CommunityAdapter()
        community_rv.layoutManager = LinearLayoutManager(getActivity())

        fabWrite_community.setOnClickListener{
            val intent = Intent(getContext(), CommunityWriteActivity::class.java)
            startActivity(intent)
        }
    }
}