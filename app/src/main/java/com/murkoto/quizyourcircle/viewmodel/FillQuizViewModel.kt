package com.murkoto.quizyourcircle.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.murkoto.quizyourcircle.model.Submission
import com.murkoto.quizyourcircle.repository.FillQuizRepository

class FillQuizViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepo = FillQuizRepository(application)

    val submission = Submission()

    fun getQuizWithQuestions(quizId: Long) = mRepo.getQuizWithQuestionsWithOptions(quizId)

    fun submitQuiz() {
        mRepo.submitQuiz(submission)
    }

}