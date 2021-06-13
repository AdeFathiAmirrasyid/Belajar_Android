package com.insanie.fakeapi.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.insanie.fakeapi.databinding.FragmentOverviewBinding


class OverviewFragment : Fragment() {

    private lateinit var viewModel : OverviewViewModel
    private lateinit var binding : FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)
        binding   = FragmentOverviewBinding.inflate(inflater)

        binding.setLifecycleOwner  (this)
        binding.viewModel = viewModel

        //add recycleview
        val viewAdapter = ItemAdapter()
        binding.recyclerView.adapter =viewAdapter

        viewModel.items.observe(viewLifecycleOwner,Observer{list ->
        viewAdapter.submitList(list)
        })
        return binding.root
    }
}