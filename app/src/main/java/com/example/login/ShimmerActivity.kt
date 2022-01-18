package com.example.myapplication.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.login.Composable.ShimmerAnimation
import com.example.myapplication.ui.theme.MyApplicationTheme


class ShimmerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme(darkTheme = false) {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        repeat(5) {
                            item {
                                ShimmerAnimation()
                            }
                        }
                    }
                }
            }
        }
    }

}



