package com.murkoto.quizyourcircle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemQuestionFormBinding
import com.murkoto.quizyourcircle.model.Question
import kotlinx.android.extensions.LayoutContainer

class QuestionFormRecyclerViewAdapter(val context: Context):
    RecyclerView.Adapter<QuestionFormRecyclerViewAdapter.QuestionViewHolder>() {

    val questions: List<Question> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemQuestionFormBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_question_form, parent, false
        )
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class QuestionViewHolder(val binding: ItemQuestionFormBinding): RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View?
            get() = binding.root

        fun bind(question: Question) {

        }
    }

}