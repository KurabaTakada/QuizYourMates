package com.murkoto.quizyourcircle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemQuestionAnswerBinding
import com.murkoto.quizyourcircle.model.Question

class QuestionAnswerRecyclerViewAdapter(val questions : MutableList<Question>):
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
        val question = questions[position]
        holder.binding.question = question
        holder.setupOptions(question)
    }

    class QuestionAnswerViewHolder(val binding: ItemQuestionAnswerBinding): RecyclerView.ViewHolder(binding.root) {
        fun setupOptions(question: Question) {
            binding.rvOptionsForm.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
            binding.rvOptionsForm.adapter = OptionAnswerRecyclerViewAdapter(question.options)
        }
    }

}