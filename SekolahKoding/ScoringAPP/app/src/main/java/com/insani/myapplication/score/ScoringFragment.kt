package com.insani.myapplication.score

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.insani.myapplication.R
import com.insani.myapplication.databinding.FragmentScoringBinding


class ScoringFragment : Fragment() {

    private lateinit var viewModel : ScoreViewModel
    private lateinit var binding   : FragmentScoringBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scoring, container, false)
        Log.i("Scoring", "viewModel terpanggil dari scoring fragment..")
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.setLifecycleOwner(this)

        var args = ScoringFragmentArgs.fromBundle(requireArguments())

        binding.TextTim1.text = args.TextTim1
        binding.TextTim2.text = args.TextTim2

        viewModel.initTeam(args.TextTim1,args.TextTim2)

        viewModel.eventFinished.observe(viewLifecycleOwner, Observer {hasFinished ->
            if (hasFinished ) {
                viewModel.reset()
                requireView().findNavController().navigate(
                    ScoringFragmentDirections.actionScoringFragmentToFinishFragment(
                       viewModel.winnerTeam.value.toString()
                    )
                )
            }
        })

        return binding.root
    }
}
