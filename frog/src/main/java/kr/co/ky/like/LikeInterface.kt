package kr.co.ky.like

import kr.co.ky.community.CommunityDataClass

interface LikeInterface {
    fun ClickLike(collection:String, documentList: MutableList<CommunityDataClass>, position:Int)
}