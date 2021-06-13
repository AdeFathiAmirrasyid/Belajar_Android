package com.insanie.projectapi.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.insanie.projectapi.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding  : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner (this)

        //accept args

        var argUsername = DetailFragmentArgs.fromBundle(arguments!!).username
        val vmFactory   = DetailViewModelFactory(argUsername)

        binding.viewModel = ViewModelProviders.of(
            this,vmFactory).get(DetailViewModel::class.java)
        return binding.root
    }
}