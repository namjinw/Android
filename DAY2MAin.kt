package com.example.day2

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.day2.ui.theme.DAY2Theme
import java.nio.file.WatchEvent
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAY2Theme {
                mainpage()
            }
        }
    }
}

@Composable
fun mainpage() {
    Day1_1()
}

@Composable
fun Day2() {
    var mainText by remember { mutableStateOf("메인텍스트") }
    var Textsize by remember { mutableStateOf(24.sp) }
    var boxColors by remember { mutableStateOf(Color.Gray) }
    var  inputTexts by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = mainText,
            fontSize = Textsize,
            modifier = Modifier
                .width(200.dp)
                .height(140.dp)
                .background(Color.LightGray),
            textAlign = TextAlign.Center
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .border(1.dp, Color.Black),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { mainText = "버튼1눌림" }) {
                Text("버튼1")
            }
            Button(onClick = { mainText = "버튼2눌림" }) {
                Text("버튼2")
            }
            Button(onClick = { mainText = "버튼3눌림" }) {
                Text("버튼3")
            }
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(onClick = { Textsize = (Textsize.value + 4f).sp }) {
                Text("크게")
            }
            Button(onClick = {if (Textsize > 12.sp) Textsize = (Textsize.value - 2f).sp}) {
                Text("작게")
            }
        }
        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(boxColors)
                    .clickable {
                        boxColors = Color(
                            red = Random.nextFloat(),
                            green = Random.nextFloat(),
                            blue = Random.nextFloat()
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("색깔바꾸기")
            }
        }
        Row (horizontalArrangement = Arrangement.Center) {
            TextField(
                value = inputTexts,
                onValueChange = { inputTexts = it },
                label = { Text("메인 텍스트 변경") }
            )
            
            Button(onClick = {
                mainText = if (inputTexts.isNotEmpty()) inputTexts else "입력 없음"
            }) { 
                Text("입력적용")
            }
        }
    }
}

@Composable
fun Day1_1() {
    var boxcolor by remember { mutableStateOf(Color.Gray) }
    var boxstr by remember { mutableStateOf("메인페이지") }
    var txtsize by remember { mutableStateOf(24.sp) }
    var txtsizeinput by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(boxcolor)
                    .clickable{boxcolor = Color(
                        red = Random.nextFloat(),
                        green = Random.nextFloat(),
                        blue = Random.nextFloat()
                    )
                        boxstr = "나지롱"
                              },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = boxstr,
                    color = Color.White,
                    fontSize = txtsize
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally)
        ) { 
            Button(onClick = {boxcolor = Color.Yellow}) {
                Text("노란색")
            }
            Button(onClick = {boxcolor = Color.DarkGray}) {
                Text("회색")
            }
            Button(onClick = {boxcolor = Color.Green}) {
                Text("초록색")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = txtsizeinput,
                onValueChange = { txtsizeinput = it },
                label = { Text("사이즈변경") }
            )
            Button(onClick = {
                var newsize = txtsizeinput.toFloatOrNull()?.sp
                if (newsize != null && newsize.value > 0f) {
                    txtsize = newsize
                }
            }) {
                Text("입력적용")
            }
        }
    }
}
