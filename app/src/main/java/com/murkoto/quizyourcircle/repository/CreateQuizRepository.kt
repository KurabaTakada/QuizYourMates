package com.murkoto.quizyourcircle.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.model.Quiz
import com.murkoto.quizyourcircle.model.QuizDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CreateQuizRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    val submitStatusLiveData = MutableLiveData<Boolean>()

    fun submitQuiz(quiz: Quiz) {
        executorService.execute {
            val quizId = db.quizDao().insert(quiz)
            quiz.questions.forEach { question ->
                question.quizId = quizId
                val questionId = db.questionDao().insert(question)
                question.options.forEach { option ->
                    option.questionId = questionId
                    db.optionDao().insert(option)
                }
            }
        }
        submitStatusLiveData.value = true
    }

}