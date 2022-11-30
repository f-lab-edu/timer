package kr.co.ky.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.office_cardview.view.*
import kr.co.ky.kozoltime.R

class CommunityAdapter(var communityList:MutableList<CommunityDataClass>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.office_cardview, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as ViewHolder).itemView

        viewHolder.card_title.text = communityList[position].title
        viewHolder.card_id.text = communityList[position].id
        viewHolder.card_context.text = communityList[position].context
    }

    override fun getItemCount(): Int {
        return communityList.size
    }

}