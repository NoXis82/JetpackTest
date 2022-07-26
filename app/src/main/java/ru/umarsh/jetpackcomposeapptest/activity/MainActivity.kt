package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.umarsh.jetpackcomposeapptest.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.lexend_thin, FontWeight.Thin),
            Font(R.font.lexend_light, FontWeight.Light),
            Font(R.font.lexend_regular, FontWeight.Normal),
            Font(R.font.lexend_medium, FontWeight.Medium),
            Font(R.font.lexend_semibold, FontWeight.SemiBold),
            Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
            Font(R.font.lexend_bold, FontWeight.Bold)
        )
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFF101010)
                    )
            ) {
                Text(
                    text = "Jetpack Compose",
                    color = Color.White,
                    fontSize = 30.sp
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 40.sp
                            )
                        ) {
                            append("J")
                        }
                        append("etpack ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 40.sp
                            )
                        ) {
                            append("C")
                        }
                        append("ompose")
                    },
                    modifier = Modifier.padding(vertical = 60.dp),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}


