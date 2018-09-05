package com.kienht.demofilterview.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kienht.demofilterview.R
import com.kienht.demofilterview.model.FilterEntity
import com.kienht.filterview.FilterView
import kotlinx.android.synthetic.main.filter_item.view.*

/**
 * @author kienht
 * @since 29/08/2018
 */
class FilterAdapter(val list: List<FilterEntity>) : RecyclerView.Adapter<FilterAdapter.FilterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filter_item, parent, false)
        return FilterHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        holder.bindData(list[position])
    }

    inner class FilterHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(filter: FilterEntity) {
            itemView.filter_label.color = Color.parseColor(filter.color)
            itemView.filter_label.selectedTextColor = Color.WHITE
            itemView.filter_label.text = filter.name
            itemView.filter_label.isChecked = filter.isChecked
            itemView.filter_label.setOnClickListener {
                val checked = !filter.isChecked
                (it as FilterView).animateCheckedAndInvoke(checked) {
                    filter.isChecked = checked
                }
            }
        }
    }
}