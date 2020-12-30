package com.example.android4a

import com.example.android4a.data.remote.PokeCardApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

 class Singletons{
    private var cardApiInstance: PokeCardApi? = null

    fun getCardApi(): PokeCardApi? {
        if (cardApiInstance == null) {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            cardApiInstance = retrofit.create(PokeCardApi::class.java)
        }
        return cardApiInstance
    }
}