package kr.co.ky.community

import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.NonDisposableHandle.parent
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.OfficeCardviewBinding
import kr.co.ky.like.Like
import kr.co.ky.like.LikeInterface
import kotlin.properties.Delegates

class CommunityAdapter(var communityList:MutableList<CommunityDataClass>, val collection: String, val likeInterface: LikeInterface): RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {

    val uid = FirestoreKey.auth.currentUser?.uid
    val option = RequestOptions().error(R.drawable.ic_add_a_photo)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.office_cardview, parent, false)
        val binding = OfficeCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    inner class ViewHolder(private val binding: OfficeCardviewBinding): RecyclerView.ViewHolder(binding.root){
        val likeImage = binding.likeImage
        fun bind(title:String?,id:String?,date:String?,likeCount:String?) {
            binding.cardTitle.text = title
            binding.cardId.text = id
            binding.cardDate.text = date
            binding.likeCount.text = likeCount
            Glide.with(itemView)
                .load(communityList[bindingAdapterPosition].imageUri)
                .apply(option)
                .into(binding.cardImage)

        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.bind(communityList[position].title,
                communityList[position].id,
                communityList[position].singleDate,
                communityList[position].likeCount.toString())

        holder.likeImage.setOnClickListener {
                likeInterface.ClickLike(collection,communityList, position)
        }

        if(uid?.let { communityList[position].like?.containsKey(it) } == true){
            holder.likeImage.setImageResource(R.drawable.ic_favorite)
        } else {
            holder.likeImage.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    override fun getItemCount(): Int {
        return communityList.size
    }
}