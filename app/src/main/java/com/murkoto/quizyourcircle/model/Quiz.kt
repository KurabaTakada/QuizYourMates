package com.murkoto.quizyourcircle.model

import androidx.room.*

@Entity(tableName = "quiz")
data class Quiz (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") var title: String?
) {
    constructor(): this(0, "")
}

@Entity(tableName = "question", indices = [Index(value = ["quiz_id"])])
data class Question (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "quiz_id") var quizId: Long,
    @ColumnInfo(name= "question") var question: String
) {

    @Ignore var options: MutableList<Option> = mutableListOf()

    init {
        for (i in 1..4) {
            this.options.add(Option(0, 0, "", false))
        }
    }
}

@Entity(tableName = "option", indices = [Index(value = ["question_id"])])
data class Option (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "question_id") val questionId: Int,
    @ColumnInfo(name = "column_info") val content: String,
    @ColumnInfo(name = "correct") val correct: Boolean
)

@Entity(tableName = "submission")
data class Submission (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "quiz_id") val quizId: Int,
    @ColumnInfo(name = "submitter") val submitter: String
)

@Entity(tableName = "selection", indices = [Index(value = ["submission_id", "option_id"])])
data class Selection (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "submission_id") val submissionId: Int,
    @ColumnInfo(name = "option_id") val optionId: Int
)

data class QuestionWithOptions (
    @Embedded val question: Question,
    @Relation(
        parentColumn = "id",
        entityColumn = "question_id"
    )
    val options: List<Option>
)

data class SubmissionWithSelectionAndOption (
    @Embedded val submission: Submission,
    @Relation(
        parentColumn = "id",
        entityColumn = "submission_id"
    )
    val selectionAndOption: List<SelectionAndOption>
)

data class SelectionAndOption (
    @Embedded val selection: Selection,
    @Relation (
        parentColumn = "id",
        entityColumn = "option_id"
    )
    val option: Option
)