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
