package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "GameViewModel"
class GameViewModel : ViewModel() {
    // The current word
   private  val _word = MutableLiveData<String>()
    val word:LiveData<String>
    get()=_word

    // The current score
    private val _score=MutableLiveData<Int>()

     val  score : LiveData<Int>
         get()=_score
companion object{

    private const val DONE=0L
    private const val ONE_SECOND=1000L
    private const val CountDown_Time=10000L
}



    private val _evenGameFinsh=MutableLiveData<Boolean>()
    val evenGameFinsh:LiveData<Boolean>
    get()=_evenGameFinsh

    init {
        Log.i(TAG, "gameVewModel created! ")
        resetList()
        nextWord()
        _score.value=0
        _evenGameFinsh.value=false
        _word.value=""
    }


    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
            _word.value = wordList.removeAt(0)
    }
     fun onSkip() {
        _score.value=(score.value)?.minus(1)
        nextWord()
    }

     fun onCorrect() {
        _score.value=(score.value)?.plus(1)
        nextWord()
    }
fun onGameFinshComplete()
{
    _evenGameFinsh.value=false
}
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared: gameVewModel destroyed! ")
    }

}