package com.example.coingeckoapp.network

import com.example.coingeckoapp.data.Coin
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinGeckoApi {
    @GET("coins/markets")
    suspend fun getCoins(
        @Query("vs_currency") currency: String = "usd"
    ): List<Coin>
}
