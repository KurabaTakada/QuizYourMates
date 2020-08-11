package com.murkoto.quizyourcircle.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.murkoto.quizyourcircle.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepo = MainRepository(application)

    fun getQuizes() = mRepo.getQuizes()

}