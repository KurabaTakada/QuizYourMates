package com.murkoto.quizyourcircle.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.model.QuestionWithOptions

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questions: List<Question>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questions: Question): Long

    @Query("select * from question where quiz_id = :quizId")
    fun getQuestions(quizId: Long): LiveData<List<QuestionWithOptions>>

}