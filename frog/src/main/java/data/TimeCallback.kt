package data

import kr.co.ky.kozoltime.CommunityAdapter
import kr.co.ky.kozoltime.CommunityDataClass

interface TimeCallback {
    fun adapter(mutableList :MutableList<CommunityDataClass>)
}