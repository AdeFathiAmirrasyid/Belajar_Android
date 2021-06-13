package com.insani.myapplication.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.insani.myapplication.R
import com.insani.myapplication.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false)
        binding.BtnMulai.setOnClickListener {
            requireView().findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToScoringFragment
                (binding.TextTim1.text.toString(),binding.TextTim2.text.toString()))

        }
        return binding.root
    }
}