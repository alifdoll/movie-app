package com.alif.movieapps.ui.entity.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alif.movieapps.R
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.databinding.ItemBinding
import com.alif.movieapps.ui.detail.DetailActivity
import com.alif.movieapps.ui.entity.viewmodel.EntityViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class EntityAdapter : PagedListAdapter<DataEntity, EntityAdapter.EntityViewHolder>(DIFF_CALLBACK) {

    private var listEntity = ArrayList<DataEntity>()
    private lateinit var viewModel: EntityViewModel

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataEntity>() {
            override fun areItemsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun initialize(entities: PagedList<DataEntity>?, viewModel: EntityViewModel) {
        this.viewModel = viewModel
        submitList(entities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntityAdapter.EntityViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntityViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EntityAdapter.EntityViewHolder, position: Int) {
        val entity = getItem(position)
        if(entity != null) holder.bind(entity)
    }

    inner class EntityViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(entity: DataEntity) {
            with(binding) {
                itemTitle.text = entity.title
                itemOverview.text = entity.overview
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, entity.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, entity.type)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(entity.posterPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_error)
                        .error(R.drawable.ic_error))
                    .into(itemPoster)

                if(entity.favorite) {
                    itemButtonFavorite.text = "Remove From Favorite"
                    itemButtonFavorite.backgroundTintList = ColorStateList.valueOf(Color.parseColor(
                        "#D81B60"
                    ))
                } else {
                    itemButtonFavorite.text = "Add To Favorite"
                    itemButtonFavorite.backgroundTintList = ColorStateList.valueOf(Color.parseColor(
                        "#03A9F4"
                    ))
                }

                itemButtonFavorite.setOnClickListener {
                    if(entity.favorite) {
                        viewModel.setUnfavorite(entity)
                    } else {
                        viewModel.setFavorite(entity)
                    }
                }
            }
        }

    }

}