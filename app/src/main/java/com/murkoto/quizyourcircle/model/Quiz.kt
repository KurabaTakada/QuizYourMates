package com.murkoto.quizyourcircle.model

import androidx.room.*

@Entity(tableName = "quiz")
data class Quiz (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") var title: String? = "",
    @Ignore val questions: MutableList<Question> = mutableListOf()
)

@Entity(tableName = "question", indices = [Index(value = ["quiz_id"])])
data class Question (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "quiz_id") var quizId: Long,
    @ColumnInfo(name= "question") var question: String
) {

    @Ignore var options: MutableList<Option> = mutableListOf()

    init {
        val rand = (1..4).random()
        for (i in 1..4) {
            var isCorrect = false
            if (rand == i) isCorrect = true
            this.options.add(Option(0, 0, "", isCorrect))
        }
    }
}

@Entity(tableName = "option", indices = [Index(value = ["question_id"])])
data class Option (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "question_id") var questionId: Long = 0,
    @ColumnInfo(name = "column_info") var content: String = "",
    @ColumnInfo(name = "correct") val correct: Boolean
) {
    var selected = false
}

@Entity(tableName = "submission")
data class Submission (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "quiz_id") var quizId: Long = 0,
    @ColumnInfo(name = "submitter") var submitter: String = ""
)

@Entity(tableName = "selection", indices = [Index(value = ["submission_id", "option_id"])])
data class Selection (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "submission_id") val submissionId: Long,
    @ColumnInfo(name = "question_id") val questionId: Long,
    @ColumnInfo(name = "option_id") val optionId: Long
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
    val selectionAndOption: List<Selection>
)

data class SelectionAndOption (
    @Embedded val selection: Selection,
    @Relation (
        parentColumn = "id",
        entityColumn = "option_id"
    )
    val option: Option
)

