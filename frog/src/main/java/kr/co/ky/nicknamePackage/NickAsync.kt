package kr.co.ky.nicknamePackage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import data.NickCallback
import data.NickFirebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class NickAsync {
    suspend fun getAsyncNick(): MutableLiveData<NickDataClass> {
        return withContext(Dispatchers.IO) {
            val nickFirebase = NickFirebase()
            var nickData = MutableLiveData<NickDataClass>()
            val getNick = async {nickFirebase.sendNickFirebase(object :NickCallback{
                override fun setNickTextView(nick: MutableLiveData<NickDataClass>) {
                    nickData = nick
                }
            })}
            getNick.await()
            nickData
        }
    }
    suspend fun asyncNick(viewModelStore: ViewModelStore){
        return withContext(Dispatchers.IO){
            val viewModel = ViewModelProvider(viewModelStore, ViewModelProvider.NewInstanceFactory())[NicknameViewModel::class.java]
            val nick = async{viewModel.getNick()}
            nick.await()
        }
    }
}