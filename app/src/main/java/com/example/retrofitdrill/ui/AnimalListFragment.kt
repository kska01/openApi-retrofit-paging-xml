package com.example.retrofitdrill.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.retrofitdrill.R
import com.example.retrofitdrill.databinding.FragmentAnimalListBinding

class AnimalListFragment : Fragment() {

    private val viewModel: AnimalListViewModel by viewModels()

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_animal_list,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvAnimalList.adapter = AnimalListRVAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}