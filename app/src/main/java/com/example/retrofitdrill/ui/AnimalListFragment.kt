package com.example.retrofitdrill.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdrill.databinding.FragmentAnimalListBinding


class AnimalListFragment : Fragment() {

    private val viewModel: AnimalListViewModel by viewModels()

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val animalListAdapter = AnimalListRVAdapter()

        binding.rvAnimalList.apply {
            adapter = animalListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = layoutManager as GridLayoutManager
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                    ) {
                        viewModel.getAnimalInfo()
                    }
                }
            })
        }

        viewModel.animalList.observe(viewLifecycleOwner) {
            val animalList = viewModel.animalList.value
            animalListAdapter.submitList(animalList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}