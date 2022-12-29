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

    var _nickState = MutableLiveData<NickDataClass>()
    val nickState: LiveData<NickDataClass> = _nickState

//    init {
//        getNick().value?.let { setNickState(it) }
//        getNick().value?.nickname?.let { Log.d("추가가", it) }
//    }
    fun setNickState(value: MutableLiveData<NickDataClass>){
        _nickState = value
     Log.d("닉 세팅", _nickState.value.toString())
    }

    fun getNick() {
                NickFirebase().sendNickFirebase(object : NickCallback {
                    override fun setNickTextView(nick: MutableLiveData<NickDataClass>) {
                        setNickState(nick)
                    }
                })
        }
}

