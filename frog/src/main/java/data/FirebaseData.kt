package kr.co.ky.kozoltime

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import data.TimeCallback
import office.Post
import java.io.PipedOutputStream

class FirebaseData(){
    fun communityFirebase(path: String="community", finishedCallback: TimeCallback){
        var communityList:MutableList<CommunityDataClass> = mutableListOf()
            val database = FirebaseDatabase.getInstance().getReference().child("community")
            database.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                    Log.d("에러",error.getMessage())
                }

                override fun onDataChange(dataSnapShot: DataSnapshot) {
                    for(snapshot in dataSnapShot!!.children){
                        var item = snapshot.getValue(CommunityDataClass::class.java)
                        communityList.add(item!!)
                        Log.d("스냅","${communityList}")
                        finishedCallback.adapter(communityList)

                    }
                }
            })
    }


}



