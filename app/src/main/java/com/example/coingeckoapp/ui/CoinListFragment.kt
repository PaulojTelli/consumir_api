package com.example.coingeckoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coingeckoapp.databinding.FragmentCoinListBinding
import com.example.coingeckoapp.viewmodels.CoinViewModel

class CoinListFragment : Fragment() {

    private var _binding: FragmentCoinListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CoinViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.coins.observe(viewLifecycleOwner) { coins ->
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CoinListAdapter(coins)
            }
        }

        viewModel.fetchCoins()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
