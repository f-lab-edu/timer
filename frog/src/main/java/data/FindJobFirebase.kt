package data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.co.ky.findJob.FindJobDataClass

class FindJobFirebase {
    fun getFindJob(findJobListener: FindJobListener){
        val jobList :MutableList<FindJobDataClass> = mutableListOf()
        val database = Firebase.firestore

        database.collection("findJob").addSnapshotListener{ snapshot, e ->
            jobList.clear()
            if (snapshot != null){
                for (documnet in snapshot){
                    val item = FindJobDataClass(
                        title = documnet["title"] as? String,
                        date = documnet["date"] as? String,
                        officeName = documnet["officeName"] as? String,
                        context = documnet["context"] as? String
                    )
                    jobList.add(item)
                    findJobListener.getJobList(jobList)
                }
            }
        }
    }
}