package com.example.numberguessinggame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.numberguessinggame.ui.theme.BlueDark
import com.example.numberguessinggame.ui.theme.YellowDark

@Composable
fun WinOrLoseDialog(text: String, buttonText: String, mysteryNumber: Int, image: Painter, resetGame: ()-> Unit) {
    Dialog(onDismissRequest = resetGame) {
        Column(modifier = Modifier
            .size(300.dp)
            .background(YellowDark)
            .clip(RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "The mystery number is $mysteryNumber",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = image, contentDescription ="Icon", modifier = Modifier.size(40.dp) )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = resetGame,
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = BlueDark )
            ) {
                Text(text = buttonText, fontSize = 18.sp)
            }
        }
    }

}
@Preview
@Composable
fun WinPreview() {
    WinOrLoseDialog(text = "Congratulations\nYou won",
        mysteryNumber = 32,
        buttonText = "Play Again",
        image = painterResource(R.drawable.baseline_emoji_events),
        resetGame = {})
}
@Preview
@Composable
fun LosePreview() {
    WinOrLoseDialog(text = "Better Luck Next Time",
        buttonText = "Try Again",
        mysteryNumber = 30,
        image = painterResource(R.drawable.baseline_rowing_24),
        resetGame = {} )
}