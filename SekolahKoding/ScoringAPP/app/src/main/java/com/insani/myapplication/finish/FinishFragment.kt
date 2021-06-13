package com.insani.myapplication.finish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.insani.myapplication.R
import com.insani.myapplication.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentFinishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish, container,false)

        var args = FinishFragmentArgs.fromBundle(requireArguments())

        binding.resultText.text = args.result + " Menang!! "

        return binding.root
    }
}