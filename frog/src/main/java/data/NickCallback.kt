package data

import androidx.lifecycle.MutableLiveData

interface NickCallback {
    fun setNickTextView(nick: MutableLiveData<NickDataClass>)
}