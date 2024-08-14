package com.example.coingeckoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coingeckoapp.data.Coin
import com.example.coingeckoapp.databinding.ItemCoinBinding
import com.bumptech.glide.Glide

class CoinListAdapter(private val coins: List<Coin>) : RecyclerView.Adapter<CoinListAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(private val binding: ItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Coin) {
            binding.coinName.text = coin.name
            binding.coinPrice.text = "$${coin.current_price}"
            Glide.with(binding.coinImage.context)
                .load(coin.image)
                .into(binding.coinImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    override fun getItemCount(): Int = coins.size
}
