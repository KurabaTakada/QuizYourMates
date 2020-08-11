package com.murkoto.quizyourcircle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ItemOptionFormBinding
import com.murkoto.quizyourcircle.model.Option

class QuestionOptionRecyclerViewAdapter(private val options: MutableList<Option>, val context: Context):
    RecyclerView.Adapter<QuestionOptionRecyclerViewAdapter.OptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemOptionFormBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_option_form, parent, false)
        return OptionViewHolder(binding)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val option = options[position]
        holder.binding.option = option
    }

    class OptionViewHolder(val binding: ItemOptionFormBinding): RecyclerView.ViewHolder(binding.root)

}