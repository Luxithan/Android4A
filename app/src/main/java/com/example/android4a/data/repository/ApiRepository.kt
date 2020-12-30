package com.example.android4a.data.repository

import com.example.android4a.Constants
import com.example.android4a.Constants.ERROR_KO
import com.example.android4a.data.local.models.Card
import com.example.android4a.data.local.models.Deck
import com.example.android4a.data.remote.PokeCardApi
import com.example.android4a.presentation.main.ApplicationActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiRepository(
    private val pokeCardApi: PokeCardApi,
    private val view:ApplicationActivity
    ) {


    fun makeApiCall(): List<Card>? {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val pokeCardApi = retrofit.create(PokeCardApi::class.java)
        val pokeApi = pokeCardApi.getDeck()
        var cardList: List<Card>? = null

        pokeApi.enqueue(object : Callback<Deck> {
            override fun onResponse(call: Call<Deck>, response: Response<Deck>) {
                cardList = response.body()?.cards
                if (cardList != null) {
/*                     for (c in cardList) {
                         info(" one course : ${c.name} : ${c.imageUrl} : ${c.hp} ")
                     }
 */
                    view.showList(cardList)
                }
            }
            override fun onFailure(call: Call<Deck>, t: Throwable) {
                error(ERROR_KO)
            }
        }
        )
        return cardList
    }

}