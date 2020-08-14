package com.murkoto.quizyourcircle.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.murkoto.quizyourcircle.model.SubmissionWithSelectionAndOption

@Dao
interface SubmissionDao {

    @Query("select * from submission as sub where sub.quiz_id = :quizId")
    fun getSubmissionWithSelection(quizId: Long): LiveData<List<SubmissionWithSelectionAndOption>>

}