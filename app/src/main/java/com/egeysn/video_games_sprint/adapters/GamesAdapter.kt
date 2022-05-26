package com.egeysn.video_games_sprint.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.egeysn.video_games_sprint.R
import com.egeysn.video_games_sprint.data.generals.ResultsItem
import com.egeysn.video_games_sprint.databinding.GamesItemBinding
import com.egeysn.video_games_sprint.ui.main.home.HomeFragmentViewModel

class GamesAdapter(
    private val viewModel: HomeFragmentViewModel,
    private val items: List<ResultsItem>
) :
    ListAdapter<ResultsItem, GamesAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, items[position], items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount() = items.size

    class ViewHolder private constructor(private val binding: GamesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: HomeFragmentViewModel, item: ResultsItem, size: Int) {

            val params = binding.root.layoutParams as RecyclerView.LayoutParams
            when (bindingAdapterPosition) {
                0 -> {
                    params.topMargin =
                        dpToPx(binding.root.context, 10)
                    binding.root.layoutParams = params
                }
                size - 1 -> {
                    params.bottomMargin =
                        dpToPx(binding.root.context, 20)
                    binding.root.layoutParams = params
                }
                else -> {
                    params.topMargin = 20
                    binding.root.layoutParams = params
                }
            }

            binding.titleTv.text = item.name
            binding.descTv.text = item.released

            // create a ProgressDrawable object which we will show as placeholder
            val progress = CircularProgressDrawable(binding.root.context)
            progress.setColorSchemeColors(
                R.color.secondary,
            )
            progress.centerRadius = 30f
            progress.strokeWidth = 5f
            progress.start()

            Glide.with(binding.root.context)
                .load(item.backgroundImage)
                .placeholder(progress)
                .centerCrop()
                .into(binding.imageIv)
        }

        private fun dpToPx(context: Context, dp: Int): Int {
            val dip: Float = dp.toFloat()
            val scale = context.resources.displayMetrics.density
            return (dip * scale + 0.5f).toInt()
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
