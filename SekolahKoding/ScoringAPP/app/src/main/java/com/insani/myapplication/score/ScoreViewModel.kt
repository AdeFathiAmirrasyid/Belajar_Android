package com.insani.myapplication.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel(){

    private val _team1score = MutableLiveData<Int>()
        val team1Score : LiveData<Int>
             get() = _team1score

    val _team2score = MutableLiveData<Int>()
        val team2Score  : LiveData<Int>
             get() = _team2score

    private val _eventFinished = MutableLiveData<Boolean>()
        val eventFinished : LiveData<Boolean>
            get() = _eventFinished

    private val _winnerTeam = MutableLiveData<String>()
        val winnerTeam : LiveData<String>
            get() = _winnerTeam

    private val _teams = MutableLiveData<ArrayList<String>>()
        val winner : LiveData<ArrayList<String>>
            get() = _teams

     val score1String = Transformations.map(team1Score,{ score ->
        score.toString()
    })

     val score2String = Transformations.map(team2Score,{score ->
        score.toString()
    })

    fun initTeam(team1 : String , team2 : String){
        (_teams.value)?.add(team1)
        (_teams.value)?.add(team2)
    }

    init {
        _eventFinished.value = false
        _team1score.value    = 0
        _team2score.value    = 0
        _teams.value = ArrayList<String>()

    }
    override fun onCleared() {
        super.onCleared()
        Log.i("Scoring","gameViewModel is cleared!")
    }
    fun updateScore(team : Int){
            if (team == 1) {
                _team1score.value = (_team1score.value)?.plus(1)
                _winnerTeam.value = (_teams.value)?.get(0)
            }
            else {
                _team2score.value = (_team2score.value)?.plus(1)
                _winnerTeam.value = (_teams.value)?.get(1)
            }

            if (((_team1score.value)!! >= 3) ||
                ((_team2score.value)!! >= 3)){

            _eventFinished.value = true
        }
    }
    fun reset(){
        _eventFinished.value = false
    }
}