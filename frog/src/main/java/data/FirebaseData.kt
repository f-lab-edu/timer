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
    fun communityFirebase(path: String, finishedCallback: TimeCallback) {
    var communityList: MutableList<CommunityDataClass> = mutableListOf()
    var database = Firebase.firestore
    database.collection(path).get().addOnSuccessListener { result ->
        communityList.clear()
        for (document in result) {
            var item = CommunityDataClass(document["id"] as? String,
                document["context"] as? String,
                document["title"] as? String)
            communityList.add(item)
            finishedCallback.adapter(communityList)
        }
    }
        .addOnFailureListener { exception ->
            Log.w("실패", "$exception")
        }
}
    }




