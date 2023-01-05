package kr.co.ky.findJob

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.ky.kozoltime.databinding.FindJobCardviewBinding

class FindJobAdapter(val jobList:MutableList<FindJobDataClass>):RecyclerView.Adapter<FindJobAdapter.ViewHolder>() {

    class ViewHolder(private val binding: FindJobCardviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String?, date: String?, officeName: String?, context: String?) {
            binding.findJobCardviewTitle.text = title
            binding.findJobCardviewDate.text = date
            binding.findJobCardviewOfficeName.text = officeName
            binding.findJobCardviewContext.text = context
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FindJobCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(title = jobList[position].title,
                    date = jobList[position].date,
                    officeName = jobList[position].officeName,
                    context = jobList[position].context)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }
}