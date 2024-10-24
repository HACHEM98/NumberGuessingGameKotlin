package com.example.numberguessinggame
data class GuessingGameState (val userNumber: String = "", val guessingNumberLeft: Int = 5, val guessedGameList: List<Int> = emptyList(), val msteryNumber: Int = (0..100).random(), val hintDescription: String ="Guess\nThe mystery number Between\n 0 and 100.", val gameStage: GameStage = GameStage.playing)

enum class GameStage{ win, lose, playing}

