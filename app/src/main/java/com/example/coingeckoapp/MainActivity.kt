package com.example.coingeckoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coingeckoapp.databinding.ActivityMainBinding
import com.example.coingeckoapp.ui.CoinListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando o ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Carregar o CoinListFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CoinListFragment())
                .commit()
        }
    }
}
