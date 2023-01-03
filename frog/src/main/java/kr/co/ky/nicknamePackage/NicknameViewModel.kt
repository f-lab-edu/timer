package kr.co.ky.nicknamePackage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.NickCallback
import data.NickFirebase
import kotlinx.coroutines.*

class NicknameViewModel : ViewModel() {

    val nickFirebase = NickFirebase()
    var _nickState = MutableLiveData<NickDataClass>()
    val nickState: LiveData<NickDataClass>
        get() =_nickState

    fun setNickState(value: NickDataClass){
        _nickState.value = value
    }

    fun getNick() {
                nickFirebase.sendNickFirebase(object : NickCallback {
                    override fun setNickTextView(nick: NickDataClass) {
                        setNickState(nick)
                    }
                })
        }
}

