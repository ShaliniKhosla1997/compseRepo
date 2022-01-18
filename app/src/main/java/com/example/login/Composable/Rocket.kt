package com.example.login.Composable

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.login.R

@Composable
fun Rocket(
    isRocketEnabled: Boolean,
    maxWidth: Dp,
    maxHeight: Dp
) {
    val resource: Painter
    val modifier: Modifier
    val rocketSize = 200.dp
    if(!isRocketEnabled){
        resource = painterResource(id = R.drawable.rocket_intial)
        modifier = Modifier.offset(
            y = maxHeight - rocketSize,
        )
    }
    else{
        val infiniteTransition = rememberInfiniteTransition()
        val engineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            )
        )
        val xPositionState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        )
        if (engineState.value <= .5f) {
            resource = painterResource(id = R.drawable.rocket1)
        } else {
            resource = painterResource(id = R.drawable.rocket2)
        }
        modifier = Modifier.offset(
            x = (maxWidth - rocketSize) * xPositionState.value,
            y = (maxHeight - rocketSize) - (maxHeight - rocketSize) * xPositionState.value,
        )
    }
    Image(
        modifier = modifier.width(rocketSize).height(rocketSize),
        painter = resource,
        contentDescription = "A Rocket",
    )
}