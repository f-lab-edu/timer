package kr.co.ky.kozoltime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.office_cardview.view.*

class CommunityAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var communityList:MutableList<CommunityDataClass> = mutableListOf()
    init {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("community").addSnapshotListener{querySnapshot,firebaseFirestoreException -> communityList.clear()
            if(querySnapshot != null) {
                for (snapshot in querySnapshot!!.documents) {
                    var item = snapshot.toObject(CommunityDataClass::class.java)
                    communityList.add(item!!)
                }
            }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.office_cardview, parent, false)
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
