package com.khadija.nyarticles.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.khadija.nyarticles.databinding.ItemArticleBinding
import com.khadija.nyarticles.datalayer.entities.Results

class ResultsAdapter (val articleClicks: ArticleClicks):androidx.recyclerview.widget.ListAdapter<Results, ResultsAdapter.ResultsViewHolder>(ResultsDiffCallBack()) {
    class ResultsViewHolder private constructor(val binding: ItemArticleBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(results: Results){
            binding.result=results
            binding.executePendingBindings()

        }
        companion object{
            fun from(parent: ViewGroup):ResultsViewHolder{
                val layoutInflater= LayoutInflater.from(parent.context)
                val binding=ItemArticleBinding.inflate(layoutInflater,parent,false)
                return ResultsViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        return ResultsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        val item =getItem(position)
        holder.bind(item)
        holder.binding.clickInterface=articleClicks


    }
}
class ResultsDiffCallBack(): DiffUtil.ItemCallback<Results>() {
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return newItem == oldItem
    }

}
interface ArticleClicks{
    fun click(results: Results)
}