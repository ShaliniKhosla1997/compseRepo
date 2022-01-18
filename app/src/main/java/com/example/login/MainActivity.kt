package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.Composable.*
import com.example.login.viewModel.RagisterViewModel
import com.example.myapplication.ui.theme.DefaultTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                val navController = rememberNavController()
                //val loginViewModel = ViewModelProvider(this).get(RagisterViewModel::class.java)
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController)
                }
            }
        }
    }

    //Navigation through different composable
    @Composable
    private fun NavigationComponent(
        navController: NavHostController
    ) {
        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                SignInScreen(navController, this@MainActivity)
            }
            composable("userDetails") {
                userDetails(navController, this@MainActivity)
            }
            composable("ragister") {
                //ragisterView(navController, this@MainActivity)
                launchRocket()
            }
        }
    }
}


@Composable
fun launchRocket(){
    val animationState = remember{ mutableStateOf(false)}
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Rocket(
            isRocketEnabled = animationState.value,
            maxWidth = maxWidth,
            maxHeight = maxHeight
        )
        LaunchButton(
            animationState = animationState.value,
            onToggleAnimationState = { animationState.value = !animationState.value }
        )
    }
}
//By default, navigate() adds your new destination to the back stack.
// Pop everything up to the "home" destination off the back stack before
// navigating to the "friends" destination
//navController.navigate(“friends”) {
//    popUpTo("home")
//}

// Pop everything up to and including the "home" destination off
// the back stack before navigating to the "friends" destination
//navController.navigate("friends") {
//    popUpTo("home") { inclusive = true }
//}

// Navigate to the "search” destination only if we’re not already on
// the "search" destination, avoiding multiple copies on the top of the
// back stack
//navController.navigate("search") {
//    launchSingleTop = true
//}

//
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DefaultTheme {
//        //SignInScreen()
//    }
//}
