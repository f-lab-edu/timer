package kr.co.ky.community

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.office_cardview.view.*
import kr.co.ky.kozoltime.R
import kr.co.ky.like.Like
import kr.co.ky.like.LikeInterface
import kotlin.properties.Delegates

class CommunityAdapter(var communityList:MutableList<CommunityDataClass>, val collection: String, val likeInterface: LikeInterface): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var uid = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.office_cardview, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val viewHolder = (holder as ViewHolder).itemView

        viewHolder.card_title.text = communityList[position].title
        viewHolder.card_id.text = communityList[position].id
        viewHolder.card_context.text = communityList[position].context
        viewHolder.card_date.text = communityList[position].timestamp.toString()
        viewHolder.like_count.text = communityList[position].likeCount.toString()

        @GlideModule
        if (communityList[position].imageUri != null) {
            Glide.with(holder.itemView)
                .load(communityList[position].imageUri)
                .into(viewHolder.card_image)
        } else {
            Log.d("null", "null")
        }

        viewHolder.like_image.setOnClickListener {

            if (collection == "kozoltime") {
                likeInterface.ClickLike(collection,communityList, position)

            } else if (collection == "community") {
                likeInterface.ClickLike(collection, communityList, position)

            }
        }
        if(communityList[position].like.containsKey(uid)){
            viewHolder.like_image.setImageResource(R.drawable.ic_favorite)
        } else {
            viewHolder.like_image.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    override fun getItemCount(): Int {
        return communityList.size
    }

}