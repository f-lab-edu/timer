package data

import com.google.firebase.firestore.FirebaseFirestore
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.firestoreKey.FirestoreKey
import navigation.MyPage
import java.text.SimpleDateFormat
import java.util.*

class DetailFirebase {

    val mutableDetailList: MutableList<CommunityDataClass.Comment> = mutableListOf()
    val database = FirebaseFirestore.getInstance()
    val dateformat = SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")

    fun receiveDetailFirebase(path: String, document:String, detailCallback: DetailListener) {

        @Suppress("UNCHECKED_CAST")
        database.collection(path).document(document)
            .collection("comments").orderBy("singleDate").addSnapshotListener { snapshots, _ ->
                mutableDetailList.clear()

                if (snapshots == null) return@addSnapshotListener

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

            }
    }
    fun setDetailview(commentEditText:String?, nickname:String,page:String, documentFromAdapter:String){
        val comment = CommunityDataClass.Comment(
            uid = FirestoreKey.auth.currentUser?.uid,
            nickname = nickname,
            comment = commentEditText,
            singleDate = dateformat.format(Date()))

            FirebaseFirestore.getInstance().collection(page).document(documentFromAdapter)
                .collection("comments").document().set(comment)

    }
    }
