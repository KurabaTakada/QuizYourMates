package com.murkoto.quizyourcircle.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.murkoto.quizyourcircle.model.Submission
import com.murkoto.quizyourcircle.model.SubmissionWithSelectionAndOption

@Dao
interface SubmissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubmission(submission: Submission): Long

    @Query("select * from submission as sub where sub.quiz_id = :quizId")
    fun getSubmissionWithSelection(quizId: Long): LiveData<List<SubmissionWithSelectionAndOption>>

}