package data

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


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
                    nickCallback.setNickTextView(snapshot["nickname"] as? String)
                }
            }
        } else {
            Log.w(TAG, "email null")
        }

    }
}
