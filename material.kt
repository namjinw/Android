package com.example.pagemove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pagemove.ui.theme.PagemoveTheme
import kotlinx.coroutines.launch

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
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val open = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .width(300.dp)
                    .background(Color.Yellow)
            ) {
                Button(onClick = {
                    open.launch { drawerState.close() }
                },
                    modifier = Modifier
                        .align(Alignment.End)
                    ) { }
                Text("메뉴1")
                Text("메뉴2")
                Text("메뉴3")
                Text("메뉴4")
                Button(onClick = {
                    navController.navigate("page2") {
                        popUpTo("page1") {inclusive = false}
                    }
                }) {
                    Text("서브페이지로")
                }
            }
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(onClick = {
                open.launch {drawerState.open()}
            }) { }
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