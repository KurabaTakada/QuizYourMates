package com.murkoto.quizyourcircle.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.murkoto.quizyourcircle.model.Quiz
import com.murkoto.quizyourcircle.repository.CreateQuizRepository

class CreateQuizViewModel(application: Application): AndroidViewModel(application) {

    val mRepo = CreateQuizRepository(application)
    val quiz = Quiz()
    val submissionStatusLiveData: LiveData<Boolean>
        get() = mRepo.submitStatusLiveData

    fun submitQuiz() {
        mRepo.submitQuiz(quiz)
    }

}