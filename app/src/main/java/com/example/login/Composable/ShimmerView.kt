package com.example.login.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerView(
    brush: Brush
) {
    // Column composable containing spacer shaped like a rectangle,
    // set the [background]'s [brush] with the brush receiving from [ShimmerAnimation]
    // Composable which is the Animation you are gonna create.
    Column(modifier = Modifier.padding(16.dp)) {
        Surface(
            shape = MaterialTheme.shapes.small,
        ) {
            Spacer(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(brush = brush)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(vertical = 8.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(brush = brush)
            )
       }
//        Surface(
//            shape = MaterialTheme.shapes.small,
//            modifier = Modifier
//                .padding(vertical = 8.dp)
//        ) {
//            CircleShape
//        }
    }
}