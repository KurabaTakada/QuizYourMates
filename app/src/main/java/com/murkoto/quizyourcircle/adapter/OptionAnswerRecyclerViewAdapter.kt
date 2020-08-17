package com.murkoto.quizyourcircle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemOptionAnswerBinding
import com.murkoto.quizyourcircle.model.Option

class OptionAnswerRecyclerViewAdapter(val options: List<Option>): RecyclerView.Adapter<OptionAnswerRecyclerViewAdapter.OptionAnswerViewHolder>() {

    private var selectedPosition = -1

    class OptionAnswerViewHolder(val binding: ItemOptionAnswerBinding): RecyclerView.ViewHolder(binding.root) {
        fun setSelection() {
            binding.selectionContainer.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionAnswerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemOptionAnswerBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_option_answer, parent, false
        )
        return OptionAnswerViewHolder(binding)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: OptionAnswerViewHolder, position: Int) {
        val option = options[position]
        holder.binding.option = option
        holder.binding.selectionContainer.setOnClickListener {
            if (selectedPosition >= 0) {
                options[selectedPosition].selected = false
                notifyItemChanged(selectedPosition)
            }
            option.selected = true
            notifyItemChanged(position)
            selectedPosition = position
        }
    }

}