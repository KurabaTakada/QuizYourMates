package com.murkoto.quizyourcircle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemQuestionFormBinding
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.view.CreateQuizActivity
import kotlinx.android.extensions.LayoutContainer

class QuestionFormRecyclerViewAdapter(val questions: MutableList<Question>, val context: Context):
    RecyclerView.Adapter<QuestionFormRecyclerViewAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemQuestionFormBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_question_form, parent, false
        )
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int = questions.size

    fun addQuestion() {
        val question = Question(0, 0, "")
        questions.add(question)
        notifyItemInserted(questions.size - 1)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        holder.bind(question, context)
    }

    class QuestionViewHolder(val binding: ItemQuestionFormBinding): RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View?
            get() = binding.root

        fun bind(question: Question, context: Context) {
            binding.question = question
            binding.rvOptionsForm.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = QuestionOptionRecyclerViewAdapter(question.options, context)
            }
        }
    }

}