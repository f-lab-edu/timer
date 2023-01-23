package data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.co.ky.community.CommunityDataClass


class FirebaseData(){

    fun receiveFirebase(path: String, finishedCallback: TimeCallback) {
        val communityList: MutableList<CommunityDataClass> = mutableListOf()
        val database = Firebase.firestore
        @Suppress("UNCHECKED_CAST")
        database.collection(path).addSnapshotListener { snapshots, _ ->
            communityList.clear()
            if (snapshots != null) {
                for (document in snapshots) {
                    val item = CommunityDataClass(
                        id = document["id"] as? String,
                        context = document["context"] as? String,
                        title = document["title"] as? String,
                        imageUri = document["imageUri"] as? String,
                        singleDate = document["singleDate"] as? String,
                        document = document["document"] as? String,
                        likeCount = document["likeCount"] as? Long,
                        like = document["like"] as? MutableMap<String, Boolean>)

                    communityList.add(item)
                    finishedCallback.adapter(communityList)
                }
            }
        }
    }
}




