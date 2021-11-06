package com.alif.movieapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
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
        contentDetailBinding.progressBar.visibility = View.VISIBLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if(extras != null) {
            val type = extras.getString(EXTRA_TYPE)
            val id = extras.getInt(EXTRA_ID)

            when(type) {
                "Movie" -> viewModel.getMovieDetail(id).observe(this, Observer { movie ->
                    populate(movie)
                })

                else -> viewModel.getShowDetail(id).observe(this, Observer { show ->
                    populate(show)
                })
            }

        }

    }

    private fun populate(item: DataEntity) {
        contentDetailBinding.progressBar.visibility = View.GONE
        contentDetailBinding.overviewTag.visibility = View.VISIBLE
        supportActionBar?.title = item.title
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}