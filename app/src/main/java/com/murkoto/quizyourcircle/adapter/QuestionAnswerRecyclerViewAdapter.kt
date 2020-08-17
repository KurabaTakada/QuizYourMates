package com.murkoto.quizyourcircle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemQuestionAnswerBinding
import com.murkoto.quizyourcircle.model.Question
import com.murkoto.quizyourcircle.model.QuestionWithOptions

class QuestionAnswerRecyclerViewAdapter(val questions : List<QuestionWithOptions>):
    RecyclerView.Adapter<QuestionAnswerRecyclerViewAdapter.QuestionAnswerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAnswerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemQuestionAnswerBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_question_answer, parent, false
        )
        return QuestionAnswerViewHolder(binding)
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionAnswerViewHolder, position: Int) {
        val questionWithOptions = questions[position]
        val question = questionWithOptions.question
        question.options.clear()
        question.options.addAll(questionWithOptions.options)
        holder.binding.question = question
        holder.setupOptions(question)
    }

    class QuestionAnswerViewHolder(val binding: ItemQuestionAnswerBinding): RecyclerView.ViewHolder(binding.root) {
        fun setupOptions(question: Question) {
            binding.rvOptionsForm.apply {
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
                adapter = OptionAnswerRecyclerViewAdapter(question.options)
            }
        }
    }

}