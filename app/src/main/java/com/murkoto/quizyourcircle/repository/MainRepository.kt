package com.murkoto.quizyourcircle.repository

import android.app.Application
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.model.Quiz
import com.murkoto.quizyourcircle.database.QuizDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getQuizes() = db.quizDao().getQuizes()

}