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
import kotlinx.android.synthetic.main.fragment_community.*
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.community.CommunityWriteActivity
import kr.co.ky.kozoltime.*


class CommunityFragment : Fragment(){
    private val firebaseData = FirebaseData()
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
        val path = "community"
        community_rv.layoutManager = LinearLayoutManager(activity)
        firebaseData.sendFirebase(path, object : DataListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun adapter(mutableList: MutableList<CommunityDataClass>) {

                community_rv.adapter = CommunityAdapter(mutableList)
                (community_rv.adapter as CommunityAdapter).notifyDataSetChanged()

            }
        })

        fabWrite_community.setOnClickListener{
            val intent = Intent(context, CommunityWriteActivity::class.java)
            startActivity(intent)
        }
    }

}
