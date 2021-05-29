package edu.franksprachen.baumapp.retrofit

import retrofit2.http.GET

interface TreeRetrofit {
    @GET("13865177-701a-4e63-93d4-c03c0ee1a6a6")
    suspend fun getTrees(): List<TreeNetworkEntity>
}