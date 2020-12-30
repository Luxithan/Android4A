package com.example.android4a.data.local.models

class Deck(val cards: List<Card>)

class Card(val name: String, val imageUrl: String, val hp: String)


/*
fun getApi() : Call<Deck> {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.reddit.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val pokeCardApi = retrofit.create(PokeCardApi::class.java)
    val pokeApi = pokeCardApi.getDeck()
    return pokeApi
}

fun Deck.toCard() : Card{
    val hp = "hp"
    val imageUrl ="imageUrl"
    val name = "name"
    return Card(
        name = name,
        imageUrl = imageUrl,
        hp = hp
    )
}

fun Card.toDeck() : Deck{
    return Deck(Card(name, imageUrl, hp).toString().toList())
}

 */
