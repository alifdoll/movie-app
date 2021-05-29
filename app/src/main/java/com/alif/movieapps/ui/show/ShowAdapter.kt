package com.alif.movieapps.ui.show

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.databinding.ItemBinding
import com.alif.movieapps.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ShowAdapter : RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {
    private var listShow = ArrayList<DataEntity>()

    fun setShow(shows: List<DataEntity>?) {
        if(shows == null) return
        this.listShow.clear()
        this.listShow.addAll(shows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShow.size

    inner class ShowViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(show: DataEntity) {
            Log.d("movie adapter debug", "URL GAMBAR: ${show.posterPath}")
            with(binding) {
                itemTitle.text = show.title
                itemOverview.text = show.overview
                itemView.setOnClickListener{
                    Log.d("show adapter debug", "Item Clicked")
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, show.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, show.type)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(show.posterPath)
                    .apply(RequestOptions())
                    .into(itemPoster)
            }
        }

    }

}