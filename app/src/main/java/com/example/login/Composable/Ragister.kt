package com.example.login.Composable

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.login.viewModel.RagisterViewModel

@Composable
   fun ragisterView(navController: NavController, context: Context) {
    Text(text = "hello Ragisters")
}


@Composable
fun showText(text:String){
    Text(text = text)
}

@Preview
@Composable
fun previewText(){
    showText(text = "Preview Example")
}