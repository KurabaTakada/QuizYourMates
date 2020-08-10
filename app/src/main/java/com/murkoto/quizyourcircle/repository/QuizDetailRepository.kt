package com.murkoto.quizyourcircle.repository

import android.app.Application
import com.murkoto.quizyourcircle.model.QuizDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QuizDetailRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)

    fun getQuestions(id: Long) = db.questionDao().getQuestions(id)

}