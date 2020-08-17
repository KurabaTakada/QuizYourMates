package com.murkoto.quizyourcircle.repository

import android.app.Application
import com.murkoto.quizyourcircle.database.QuizDatabase
import com.murkoto.quizyourcircle.model.Submission
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FillQuizRepository(application: Application) {

    private val db = QuizDatabase.getDatabase(application)
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getQuizWithQuestionsWithOptions(quizId: Long) = db.questionDao().getQuestions(quizId)

    fun submitQuiz(submission: Submission) {
        executorService.execute {
            val submissionId = db.submissionDao().insertSubmission(submission)

        }
    }

}