package com.example.a1day

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1day.ui.theme._1DAYTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1DAYTheme {
                Day1()
            }
        }
    }
}

@Composable
fun Day1() {
    var buttext by remember { mutableStateOf(false) }
    var maintext by remember { mutableStateOf("메인") }
    var boxClick by remember { mutableStateOf(false) }
    var boxnumber by remember { mutableStateOf(1) }

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(1.dp, Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (buttext) "눌러짐" else "눌러봐",
                fontSize = 25.sp

            )
            Button(onClick = { buttext = !buttext } ) {
                Text("클릭하시오")
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(1.dp, Color.Black)
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = maintext,
                fontSize = 40.sp
            )
            Button(onClick = {
                maintext = "메인페이지 클릭"
            }) {
                Text("클릭하기")
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(120.dp)
                    .background(if (boxClick) Color.Blue else Color.White)
                    .align(Alignment.End)
                    .clickable{boxClick = !boxClick},
                contentAlignment = Alignment.Center
            ) {
                Text("눌러봐")
            }
            Text(
                text = boxnumber.toString(),
                fontSize = 20.sp
            )
            Button(onClick = {
                boxnumber++
            }) { 
                Text("증가")
            }
        }
    }
}