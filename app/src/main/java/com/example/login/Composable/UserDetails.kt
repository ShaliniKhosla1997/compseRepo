package com.example.login.Composable

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.login.model.UserModel
import com.example.login.viewModel.RagisterViewModel
import kotlinx.coroutines.*

@Composable
fun userDetails(navController: NavController, context: AppCompatActivity) {
        Text(text = "Dashboard",
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
            )
    //showUsers(userList = getUserList(viewModel,context))


}
 fun getUserList(viewModel: RagisterViewModel,context: AppCompatActivity):List<UserModel>{
     var list =ArrayList<UserModel>()
    viewModel.getALlUsers().observe(context, Observer<List<UserModel>>{
        list.addAll(it)
    })
     return list
}
@Composable
fun showUsers(userList: List<UserModel>) {
    LazyColumn {
        items(userList) { item ->
            messageCard(item)
        }
    }

}

@Composable
fun messageCard(user: UserModel) {
    Text(text = user.userName, color = MaterialTheme.colors.secondaryVariant)
    Spacer(modifier = Modifier.height(4.dp))

}