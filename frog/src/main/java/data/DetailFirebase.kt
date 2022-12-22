package data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kr.co.ky.community.CommunityDataClass

class DetailFirebase {
    fun receiveDetailFirebase(path: String, document:String, detailCallback: DetailListener) {

        val mutableDetailList: MutableList<CommunityDataClass.Comment> = mutableListOf()
        val database = FirebaseFirestore.getInstance()

        @Suppress("UNCHECKED_CAST")
        database.collection(path).document(document)
            .collection("comments").orderBy("singleDate").addSnapshotListener { snapshots, _ ->
            mutableDetailList.clear()
            if (snapshots != null) {
                for (shot in snapshots) {
                    val item = CommunityDataClass.Comment(
                        uid = shot["uid"] as? String,
                        nickname = shot["nickname"] as? String,
                        comment = shot["comment"] as? String,
                        singleDate = shot["singleDate"] as? String
                    )
                    mutableDetailList.add(item)
                    detailCallback.detail(mutableDetailList)
                }
            }else {
                return@addSnapshotListener
            }
        }
    }
}
