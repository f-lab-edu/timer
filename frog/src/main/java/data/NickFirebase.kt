package data

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.co.ky.community.CommunityDataClass

class NickFirebase {
    fun sendNickFirebase(nickCallback: NickCallback) {
        val fbAuth = FirebaseAuth.getInstance()
        val nickList: MutableList<NickDataClass> = mutableListOf()
        val database = Firebase.firestore
        val email = fbAuth.currentUser?.email
        val firebaseCollection = database.collection("nickname")
        if(email != null) {
            firebaseCollection.document(email).addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed", e)
                }
                if(snapshot != null && snapshot.exists()){
                    nickList.clear()
                    val item = NickDataClass(snapshot["id"] as? String,
                        snapshot["nickname"] as? String)
                    nickList.add(item)
                    nickCallback.setNickTv(nickList[0].nickname)
                }
            }
        } else {
            Log.w(TAG, "email null")
        }

    }
}
