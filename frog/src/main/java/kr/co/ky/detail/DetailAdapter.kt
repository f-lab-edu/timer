package kr.co.ky.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.databinding.DetailCardviewBinding

class DetailAdapter(private val detailChatList: MutableList<CommunityDataClass.Comment>):RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    class ViewHolder(val binding: DetailCardviewBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(nickname:String?,date:String?,context:String?){
            binding.detailCardviewNickname.text = nickname
            binding.detailCardviewDate.text = date
            binding.detailCardviewContext.text = context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nickname = detailChatList[position].nickname.toString(),
                    date = detailChatList[position].singleDate.toString(),
                    context = detailChatList[position].comment.toString())
    }

    override fun getItemCount(): Int {
       return detailChatList.size
    }
}