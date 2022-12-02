package data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.co.ky.community.CommunityDataClass


class FirebaseData(){
    fun sendFirebase(path: String, finishedCallback: TimeCallback) {
    val communityList: MutableList<CommunityDataClass> = mutableListOf()
    val database = Firebase.firestore
    database.collection(path).get().addOnSuccessListener { result ->
        communityList.clear()
        for (document in result) {
            val item = CommunityDataClass(
                id = document["id"] as? String,
                context = document["context"] as? String,
                title = document["title"] as? String,
                imageUri = document["imageUri"] as? String,
                timestamp = document["timestamp"] as? Long)

            communityList.add(item)
            finishedCallback.adapter(communityList)
        }
    }
        .addOnFailureListener { exception ->
            Log.w("실패", "$exception")
        }
    }
    }




