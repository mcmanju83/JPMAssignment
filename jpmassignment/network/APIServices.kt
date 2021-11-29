package com.mcm.jpmassignment.network

import com.mcm.jpmassignment.model.Albums
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIServices {
    @Headers("Accept: application/json")
    @GET("albums")
    suspend fun getTitles(): List<Albums>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): APIServices {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIServices::class.java)
        }
    }
}
