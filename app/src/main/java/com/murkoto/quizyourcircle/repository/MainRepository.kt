package com.murkoto.quizyourcircle.repository

import android.app.Application
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.model.Quiz
import com.murkoto.quizyourcircle.model.QuizDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getQuizes() = db.quizDao().getQuizes()

    fun addDummyQuiz() {
        val quiz = Quiz()
        quiz.title = "quiz " + System.currentTimeMillis()
        executorService.execute {
            val id = db.quizDao().insert(quiz)
            val questions = mutableListOf<Question>()
            questions.add(Question(0, id, "really?"))
            questions.add(Question(0, id, "really?"))
            questions.add(Question(0, id, "really?"))
            db.questionDao().insert(questions)
        }
    }

}