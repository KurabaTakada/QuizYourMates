package com.murkoto.quizyourcircle.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questions: List<Question>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(questions: Question): Long

    @Query("select * from question where quiz_id = :quizId")
    fun getQuestions(quizId: Long): LiveData<List<QuestionWithOptions>>

}