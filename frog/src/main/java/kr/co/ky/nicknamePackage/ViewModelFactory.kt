package kr.co.ky.nicknamePackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory:ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NicknameViewModel::class.java)){
            return NicknameViewModel() as T
        }
        throw java.lang.IllegalArgumentException("뷰 모델을 만들 수 없습니다. : IllegalArgumentException")
    }
}