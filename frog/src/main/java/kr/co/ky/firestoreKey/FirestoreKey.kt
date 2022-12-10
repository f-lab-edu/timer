package kr.co.ky.firestoreKey

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class FirestoreKey {
    companion object{
        val auth = FirebaseAuth.getInstance()
        val storage = FirebaseStorage.getInstance()

    }
}