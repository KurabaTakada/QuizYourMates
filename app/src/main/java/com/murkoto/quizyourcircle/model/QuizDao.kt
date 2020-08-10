package com.murkoto.quizyourcircle.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quiz:Quiz): Long

    @Query("SELECT * FROM quiz ORDER BY id desc")
    fun getQuizes(): LiveData<List<Quiz>>

}