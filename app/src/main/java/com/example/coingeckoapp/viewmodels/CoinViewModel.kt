package com.example.coingeckoapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingeckoapp.data.Coin
import com.example.coingeckoapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    val coins = MutableLiveData<List<Coin>>()

    fun fetchCoins() {
        viewModelScope.launch {
            val coinList = RetrofitInstance.api.getCoins()
            coins.postValue(coinList)
        }
    }
}
