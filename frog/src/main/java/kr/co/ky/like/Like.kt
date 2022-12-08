package kr.co.ky.like

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import data.TimeCallback
import kr.co.ky.community.CommunityDataClass

class Like:LikeInterface {
    override fun ClickLike(collection:String, documentList: MutableList<CommunityDataClass>, position:Int) {
        val firestore = Firebase.firestore
        val doc = firestore.collection(collection).document(documentList[position].document!!)

        firestore.runTransaction { transaction ->

            var uid = FirebaseAuth.getInstance().currentUser?.uid
            var communityDataClass = transaction.get(doc).toObject(CommunityDataClass::class.java)

            if (communityDataClass!!.like.containsKey(uid)) {
                communityDataClass.likeCount = communityDataClass.likeCount - 1
                communityDataClass.like.remove(uid)
            } else {
                communityDataClass.likeCount = communityDataClass.likeCount + 1
                communityDataClass.like[uid!!] = true
            }
            transaction.set(doc, communityDataClass)
        }
    }
}
