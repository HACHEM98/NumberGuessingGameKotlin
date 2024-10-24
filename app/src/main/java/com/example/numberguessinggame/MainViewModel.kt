package com.example.numberguessinggame

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


public class MainViewModel: ViewModel() {
    private val _state = MutableStateFlow(GuessingGameState())
    val state = _state.asStateFlow()
    fun updateTextField(no: String){
        _state.update { it.copy(userNumber = no) }
    }
    fun resetGame() {
        _state.value = GuessingGameState()
    }
    fun onUserInpt(userNumber: String, context: Context) {
        val userNumberToInt = try {userNumber.toInt()} catch (e:Exception) {0}
        if(userNumberToInt !in 0..100){
            Toast.makeText(context, "please enter a number between 0 and 100", Toast.LENGTH_SHORT).show()
            return
        }
        val currentState = _state.value
        val newNumberLeft = currentState.guessingNumberLeft - 1
        val newGuessedList = currentState.guessedGameList.plus(userNumberToInt)
        val newGuessGameStage = when {
            userNumberToInt == currentState.msteryNumber -> {GameStage.win}
            newNumberLeft == 0 -> {GameStage.lose}
            else -> GameStage.playing
        }
        val newHintDes = when {
            userNumberToInt > currentState.msteryNumber -> {"Hint\n Your are guessing a number bigger then the mystery number "}
            userNumberToInt < currentState.msteryNumber -> {"Hint\n You are guessing a number smaller then the mystery number"}
            else -> ""
         }
        _state.update {
            it.copy(
                userNumber = "",
                guessingNumberLeft = newNumberLeft,
                guessedGameList = newGuessedList,
                hintDescription =  newHintDes,
                gameStage = newGuessGameStage

            )
        }
    }
}
