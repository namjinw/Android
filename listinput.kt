package com.example.day2_1

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.day2_1.ui.theme.DAY21Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAY21Theme {
                mainpage()
            }
        }
    }
}

@Composable
fun mainpage() {
    DAY2_1()
}

@Composable
fun DAY2_1() {
    var itemslist by remember { mutableStateOf(listOf<String>()) }
    var inputitem by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
        ) {
            TextField(
                value = inputitem,
                onValueChange = { inputitem = it },
                label = {Text("리스트 추가")}
            )
            Button(onClick = {
                if (inputitem.isNotEmpty()) {
                    itemslist = itemslist + inputitem
                    inputitem = ""
                }
            }) { Text("추가") }
        }
        LazyColumn (
            modifier = Modifier
                .width(200.dp)
                .border(1.dp, Color.Black)
        ) {
            items(itemslist) { item ->
                CardItem(item)
            }
        }
    }
}

@Composable
fun CardItem(itemtext: String) {
    var clicked by remember { mutableStateOf(false) }
    val color = if (clicked) Color.Cyan else Color.LightGray

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color)
            .clickable { clicked = !clicked }
            .padding(16.dp)
            .border(1.dp, Color.Black),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = itemtext, fontSize = 18.sp)
    }
}