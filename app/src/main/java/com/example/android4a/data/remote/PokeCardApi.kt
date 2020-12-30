package com.example.android4a.data.remote
import com.example.android4a.data.local.models.Deck
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface PokeCardApi {
    @GET("/v1/cards")
    fun getDeck(): Call<Deck>


}

