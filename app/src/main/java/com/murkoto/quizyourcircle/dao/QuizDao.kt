package com.murkoto.quizyourcircle.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.murkoto.quizyourcircle.model.Quiz

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quiz: Quiz): Long

    @Query("SELECT * FROM quiz ORDER BY id desc")
    fun getQuizes(): LiveData<List<Quiz>>

}