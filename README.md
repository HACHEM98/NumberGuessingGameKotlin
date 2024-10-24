# Number Guessing Game

A simple Number Guessing Game built using Jetpack Compose. The player has to guess a mystery number between 0 and 100 within 5 attempts. The game provides hints after each guess to help the player narrow down their guesses. If the player guesses the number correctly, they win; otherwise, they lose after 5 wrong guesses.

## Features

- **Random Mystery Number:** A new number between 0 and 100 is generated at the start of each game.
- **User Input:** Players input their guess, which is validated to ensure it's within the range.
- **Hints:** After each guess, a hint is displayed, indicating whether the guess is too high or too low.
- **Limited Guesses:** Players have 5 chances to guess the correct number.
- **Win/Lose Dialogs:** A congratulatory message or a "try again" message is shown based on the outcome.
- **Reset:** Option to restart the game after winning or losing.

## Screenshots

- **Main Game Screen:**  
  Players can see their remaining guesses, previous guesses, and input their next guess.

- **Win Screen:**  
  A celebratory screen appears when the player guesses the correct number.

- **Lose Screen:**  
  A "Better luck next time" message is shown if the player runs out of guesses.

## Setup

To run this game, follow the steps below:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/number-guessing-game.git
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.
## Requirements
- Android SDK 24 or higher
- Kotlin 1.8 or higher
- Jetpack Compose 1.4.0 or higher
## How to Play
1. The game starts by generating a random mystery number between 0 and 100.
2. The player has 5 attempts to guess the number.
3. After each guess, a hint will be provided: whether the guess is too high or too low.
4. The game ends either when the player guesses the number or when they run out of guesses.
5. After winning or losing, the player can restart the game by clicking the respective button.
## Project Structure
- MainActivity.kt : Initializes the game and sets up the UI using Jetpack Compose.
- GuessingGameScreen.kt : Contains the main game logic and UI components for the game screen.
- MainViewModel.kt : Manages the game state, including handling user input and game reset logic.
- GuessingGameState.kt : Defines the state of the game including the mystery number, guessed numbers, and remaining attempts.
## Screenshots
![Dice Roller Screenshot](screenshots/dice_roller.png)
## License
This project is licensed under the MIT License .
