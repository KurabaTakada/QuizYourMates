package com.murkoto.quizyourcircle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemSubmissionBinding
import com.murkoto.quizyourcircle.model.SubmissionWithSelectionAndOption

class SubmissionRecyclerViewAdapter:
    RecyclerView.Adapter<SubmissionRecyclerViewAdapter.SubmissionViewHolder>() {

    private val submissions = mutableListOf<SubmissionWithSelectionAndOption>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubmissionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSubmissionBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_submission, parent, false
        )
        return SubmissionViewHolder(binding)
    }

    override fun getItemCount(): Int = submissions.size

    override fun onBindViewHolder(holder: SubmissionViewHolder, position: Int) {
        val submission = submissions[position]
        holder.binding.submission = submission
    }

    class SubmissionViewHolder(val binding: ItemSubmissionBinding): RecyclerView.ViewHolder(binding.root)

}