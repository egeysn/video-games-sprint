package com.egeysn.video_games_sprint.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.egeysn.video_games_sprint.data.generals.ResultsItem
import com.egeysn.video_games_sprint.databinding.GamesItemBinding
import com.egeysn.video_games_sprint.ui.main.home.HomeFragmentViewModel

class GamesAdapter(private val viewModel: HomeFragmentViewModel) :
    ListAdapter<ResultsItem, GamesAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(viewModel, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: GamesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: HomeFragmentViewModel, item: ResultsItem) {
            binding.titleTv.text = item.name

            Glide.with(binding.root.context)
                .load(item.backgroundImage)
                .into(binding.imageIv)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GamesItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<ResultsItem>() {
    override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
        return oldItem == newItem
    }
}
