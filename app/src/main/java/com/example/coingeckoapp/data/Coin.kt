package com.example.coingeckoapp.data

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val current_price: Double,
    val image: String
)
