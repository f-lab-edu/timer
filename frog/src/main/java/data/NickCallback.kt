package data

import androidx.lifecycle.MutableLiveData
import kr.co.ky.nicknamePackage.NickDataClass

interface NickCallback {
    fun setNickTextView(nick: NickDataClass)
}