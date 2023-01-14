package kr.co.ky.cardviewCollection

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.detail.DetailPage

class CardviewCollection:CardviewInterface {

    override fun selectCollection(context: Context,page:String, document:String) {

        val intent : Intent = Intent(context.applicationContext, DetailPage::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("page", page)
        intent.putExtra("document",document)
        context.startActivity(intent)
    }

}