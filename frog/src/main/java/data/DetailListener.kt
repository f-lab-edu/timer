package data

import kr.co.ky.community.CommunityDataClass

interface DetailListener {
    fun detail(mutableDetailList: MutableList<CommunityDataClass.Comment>)
}