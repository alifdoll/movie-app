package com.alif.movieapps.data.source.remote.api

import com.alif.movieapps.data.source.remote.response.EntityItems
import com.alif.movieapps.data.source.remote.response.EntityResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //REQUEST FOR MOVIE
    @GET("discover/movie")
    fun getMovie(
            @Query("api_key") api_key: String,
            @Query("language") language: String = "en-US"
    ): Call<EntityResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
            @Path("id") id: String,
            @Query("api_key") api_key: String,
            @Query("language") language: String = "en-US"
    ): Call<EntityItems>
//========================================================

    //REQUEST FOR TV SHOW
    @GET("discover/tv")
    fun getShow(
            @Query("api_key") api_key: String,
            @Query("language") language: String = "en-US"
    ): Call<EntityResponse>

    @GET("tv/{id}")
    fun getShowDetail(
            @Path("id") id: String,
            @Query("api_key") api_key: String,
            @Query("language") language: String = "en-US"
    ): Call<EntityItems>
}