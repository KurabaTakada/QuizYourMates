package com.murkoto.quizyourcircle.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.murkoto.quizyourcircle.repository.QuizDetailRepository

class QuizDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepo = QuizDetailRepository(application)

    fun getSubmissions(quizId: Long) = mRepo.getSubmissions(quizId)

}