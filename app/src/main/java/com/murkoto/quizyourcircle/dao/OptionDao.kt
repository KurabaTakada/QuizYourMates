package com.murkoto.quizyourcircle.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.murkoto.quizyourcircle.model.Option

@Dao
interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(option: Option): Long

}