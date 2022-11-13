package com.example.appfordisplaying.view.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.appfordisplaying.databinding.FragmentMainBinding
import com.example.appfordisplaying.view.adapters.FragmentAdapter
import com.example.appfordisplaying.view.viewModels.FragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    private val viewModel by viewModel<FragmentViewModel>()
    private val listItemAdapter = FragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        viewModel.loadItemList()
        fragmentAdapter()
        fragmentObserver()

        return binding!!.root
    }

    private fun fragmentAdapter() {
        binding!!.recyclerViewItemList.apply {
            adapter = listItemAdapter
        }
    }

    private fun fragmentObserver() {
        viewModel.itemList.observe(viewLifecycleOwner) {
            listItemAdapter.submitList(it)
            binding!!.recyclerViewItemList.visibility = ProgressBar.VISIBLE
            binding!!.progressBarMain.visibility = ProgressBar.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}