package com.alif.movieapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.databinding.ActivityDetailBinding
import com.alif.movieapps.databinding.ContentDetailBinding
import com.alif.movieapps.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_ENTITY = "extra_entity"
    }

    private lateinit var contentDetailBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        if(extras != null) {
            val type = extras.getString(EXTRA_TYPE)
            val id = extras.getString(EXTRA_ID)
            if(type != null && id != null) {
                if(type == "Movie") {
                    viewModel.getMovieDetail(id).observe(this, Observer { movie ->
                        populate(movie)
                    })
                } else {
                    viewModel.getShowDetail(id).observe(this, Observer { show ->
                        populate(show)
                    })
                }
            }
        }

    }

    private fun populate(item: DataEntity) {
        contentDetailBinding.detailTitle.text = item.title
        contentDetailBinding.detailOverview.text = item.overview

        Glide.with(this)
                .load(item.posterPath)
                .apply(RequestOptions())
                .into(contentDetailBinding.detailPoster)


        Glide.with(this)
                .load(item.posterPath)
                .apply(RequestOptions())
                .into(contentDetailBinding.detailPosterBg)
    }
}