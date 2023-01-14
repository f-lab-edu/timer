package kr.co.ky.like

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import data.TimeCallback
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.firestoreKey.FirestoreKey

class Like:LikeInterface {
    override fun ClickLike(collection:String, documentList: MutableList<CommunityDataClass>, position:Int) {
        val firestore = Firebase.firestore
        val doc = documentList[position].document?.let {
            firestore.collection(collection).document(it)
        }
        firestore.runTransaction { transaction ->

            val uid = FirestoreKey.auth.currentUser?.uid
            val communityDataClass = doc?.let { transaction.get(it).toObject(CommunityDataClass::class.java) }

            if (communityDataClass?.like!!.containsKey(uid)) {
                communityDataClass.likeCount = communityDataClass.likeCount?.minus(1)
                communityDataClass.like.remove(uid)
            } else {
                communityDataClass.likeCount = communityDataClass.likeCount?.plus(1)
                communityDataClass.like[uid!!] = true
            }

                transaction.set(doc, communityDataClass)

        }
    }
}
