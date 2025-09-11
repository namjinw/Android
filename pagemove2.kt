package com.example.pagemove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pagemove.ui.theme.PagemoveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagemoveTheme {
                Mymainpage()
            }
        }
    }
}

@Composable
fun Mymainpage() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "page1"
    ) {
        composable ("page1") { page1(navController) }
        composable ("page2") { page2(navController) }
    }
}

@Composable
fun page1(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            navController.navigate("page2") {
                popUpTo("page1") {inclusive = false}
            }
        }) {
            Text("서브페이지로")
        }
    }
}

@Composable
fun page2(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            navController.navigate("page1") {
                popUpTo("page2") {inclusive = false}
            }
        }) {
            Text("메인페이지로")
        }
    }
}