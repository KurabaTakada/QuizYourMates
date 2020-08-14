package com.murkoto.quizyourcircle.repository

import android.app.Application
import com.murkoto.quizyourcircle.database.QuizDatabase

class QuizDetailRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)

    fun getSubmissions(quizId: Long) = db.submissionDao().getSubmissionWithSelection(quizId)

}