package com.game.gametebak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.game.gametebak.databinding.FragmentFinisBinding


class FinisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Selesai"
        val binding : FragmentFinisBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_finis,container,false)

        var args = FinisFragmentArgs.fromBundle(requireArguments())
        binding.explainText.text=args.result

        return binding.root
    }
}