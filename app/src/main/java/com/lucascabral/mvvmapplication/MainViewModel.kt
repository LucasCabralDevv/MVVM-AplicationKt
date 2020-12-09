package com.lucascabral.mvvmapplication

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mRepository = PersonRepository()

    private var mTitleTextView = MutableLiveData<String>()  // ou -> .apply { value = "Hello World!" }
    var titleTextView = mTitleTextView

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTitleTextView.value = "Hello World!"
    }

    fun login(userLogin: String){
        val ret = mRepository.login(userLogin)
        mLogin.value = ret
    }
}