package com.example.myapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.login.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
private val Poppins = FontFamily(
    Font(R.font.quicksand_regular),
    Font(R.font.quicksandlight, weight = FontWeight.Light),
    Font(R.font.quicksandbold, weight = FontWeight.Bold),
    Font(R.font.quicksandmedium, weight = FontWeight.Black),
)

val TypographySecond = Typography(
    defaultFontFamily = Poppins
)