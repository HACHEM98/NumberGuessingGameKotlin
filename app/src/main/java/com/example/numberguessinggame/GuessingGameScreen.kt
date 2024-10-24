package com.example.numberguessinggame

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.numberguessinggame.ui.theme.BlueDark
import com.example.numberguessinggame.ui.theme.YellowDark
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessingGameScreen(viewModel: MainViewModel) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()
    when (state.gameStage) {
        GameStage.playing -> {
            ScreenContent(state = state, onValueChange = {viewModel.updateTextField(no = it)}, onEnterButtonClicked = {viewModel.onUserInpt(userNumber = state.userNumber, context = context)})
        }
        GameStage.win -> {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(BlueDark)
                .padding(20.dp)) {
                WinOrLoseDialog(text = "Congratulations\nYou won",
                    mysteryNumber = state.msteryNumber,
                    buttonText = "Play Again",
                    image = painterResource(R.drawable.baseline_emoji_events),
                    resetGame = {viewModel.resetGame()})
            }
        }
        GameStage.lose -> {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(BlueDark)
                .padding(20.dp)) {
                WinOrLoseDialog(text = "Better Luck Next Time",
                    buttonText = "Try Again",
                    mysteryNumber = state.msteryNumber,
                    image = painterResource(R.drawable.baseline_rowing_24),
                    resetGame = {viewModel.resetGame()} )
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(state: GuessingGameState, onValueChange: (String) -> Unit, onEnterButtonClicked: (String)-> Unit) {
    val focusRequest = remember {
        FocusRequester()
    }
    LaunchedEffect(key1 = Unit ) {
        delay(500)
        focusRequest.requestFocus()
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(BlueDark)
        .padding(20.dp)) {
        Text(text = buildAnnotatedString {
            append("Number Of Guessing Left : ")
            withStyle(style = SpanStyle(color = Color.White)){
                append("${state.guessingNumberLeft}")
            }
        },
            color = YellowDark,
            fontSize = 20.sp
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            state.guessedGameList.forEach(){number ->
                Text(text = "$number", color = YellowDark, fontSize = 25.sp, modifier = Modifier.padding(10.dp))
            }
        }
        Text(text = state.hintDescription,
            color= Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White)
            .focusRequester(focusRequest)
            ,
            value = state.userNumber,
            onValueChange = onValueChange,
            textStyle = TextStyle(textAlign = TextAlign.Center, fontSize = 48.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Transparent),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {onEnterButtonClicked(state.userNumber)}
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier
            .align(Alignment.End)
            .padding(end = 20.dp)

            ,
            onClick = { onEnterButtonClicked(state.userNumber) },
            colors = ButtonDefaults.buttonColors( containerColor = YellowDark, // Set the background color
                contentColor = Color.Black)) {
            Text(text = "Enter Your Guess", fontSize = 17.sp)
        }
    }
}
@Preview
@Composable
fun Prev() {
   //* GuessingGameScreen()
}