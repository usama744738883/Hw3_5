package com.example.hw_3_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_3_5.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var isCountTen = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startIncrementingOrDecrementing()
    }

    private fun startIncrementingOrDecrementing() = with(binding) {
        var count = tvCount.text.toString().toInt().plus(1)
        binding.btn.setOnClickListener {
            when (isCountTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            tvCount.text = count++.toString()
                        }
                        true -> {
                            isCountTen = true
                            tvCount.text = count--.toString()
                            binding.btn.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            tvCount.text = count--.toString()
                        true -> requireActivity().supportFragmentManager.beginTransaction().replace(
                            R.id.fragment_container,
                            SecondFragment()
                        ).addToBackStack(null).commit()
                    }
                }
            }
        }
    }
}