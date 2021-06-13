package com.game.gametebak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.game.gametebak.databinding.FragmentQuizBinding



class QuizFragment : Fragment() {

    val question = arrayOf(

        "Apa yang kamu minum saat sedang bersantai?",
        "Apa yang kamu minum saat sedang kerja?",
        "Apa yang kamu minum saat berkumpul sama teman-teman?"
    )
    var coffie_score = 0
    var teh_score    = 0
    var current_q    = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Quiz"
        val binding : FragmentQuizBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_quiz,container,false)

        binding.questionText.text = question[current_q]
        binding.coffieBtn.setOnClickListener{
            coffie_score++
            nextQuestion(binding)
        }
        binding.btnTeh.setOnClickListener{
            teh_score++
            nextQuestion(binding)
        }
        return binding.root
    }
    fun nextQuestion(binding: FragmentQuizBinding){
    current_q++
        if (current_q < question.size){
            binding.questionText.text = question[current_q]
            Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
        }
        else   {
            var result = ""
            if (coffie_score >= 1 && teh_score >= 1){
                result = "Kamu suka dua-duanya"
            }else if (coffie_score < 1){
                result = "Kamu pecinta  teh"
            }else{
                result = "Kamu suka coffie"
            }
          requireView().findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToFinisFragment(result))

        }
    }
}