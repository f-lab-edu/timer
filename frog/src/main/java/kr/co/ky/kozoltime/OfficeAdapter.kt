package kr.co.ky.kozoltime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.office_cardview.view.*

class OfficeAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
   var postList:ArrayList<Post> = arrayListOf()
    init {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("kozoltime").addSnapshotListener{querySnapshot,firebaseFirestoreException -> postList.clear()

        for(snapshot in querySnapshot!!.documents){
            var item = snapshot.toObject(Post::class.java)
            postList.add(item!!)
        }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.office_cardview, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as ViewHolder).itemView

        viewHolder.card_title.text = postList[position].title
        viewHolder.card_id.text = postList[position].id
        viewHolder.card_context.text = postList[position].context
    }

    override fun getItemCount(): Int {
            return postList.size
        }
    }

