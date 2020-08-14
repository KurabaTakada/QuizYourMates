package com.murkoto.quizyourcircle.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.model.Quiz
import com.murkoto.quizyourcircle.view.QuizDetailActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_quiz.view.*

class QuizRecyclerViewAdapter(val context: Context): RecyclerView.Adapter<QuizRecyclerViewAdapter.QuizViewHolder>() {

    private val quizes = mutableListOf<Quiz>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return QuizViewHolder(layoutInflater.inflate(R.layout.item_quiz, parent, false))
    }

    override fun getItemCount(): Int = quizes.size

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val quiz = quizes[position]
        holder.bind(quiz)
        holder.containerView.setOnClickListener {
            val intent = Intent(context, QuizDetailActivity::class.java)
            intent.putExtra("hai", quiz.id)
            intent.putExtra("hiu", quiz.title)
            context.startActivity(intent)
        }
    }

    fun updateList(quizes: List<Quiz>) {
        this.quizes.clear()
        this.quizes.addAll(quizes)
        notifyDataSetChanged()
    }

    class QuizViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(quiz: Quiz) {
            containerView.tvQuizTitle.text = quiz.title
        }
    }

}