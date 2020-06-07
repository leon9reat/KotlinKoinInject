package com.medialink.kotlinkoininject

import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    fun getUsers(): Call<List<GithubUserItem>>
}