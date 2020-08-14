package com.murkoto.quizyourcircle.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.murkoto.quizyourcircle.dao.OptionDao
import com.murkoto.quizyourcircle.dao.QuestionDao
import com.murkoto.quizyourcircle.dao.QuizDao
import com.murkoto.quizyourcircle.dao.SubmissionDao
import com.murkoto.quizyourcircle.model.*

@Database(entities = [
    Quiz::class,
    Question::class,
    Option::class,
    Submission::class,
    Selection::class
]
    , version = 1, exportSchema = false)
abstract class QuizDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun quizDao(): QuizDao

    abstract fun questionDao(): QuestionDao

    abstract fun optionDao(): OptionDao

    abstract fun submissionDao(): SubmissionDao

}