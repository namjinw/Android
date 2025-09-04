package com.example.mylayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mylayout.ui.theme.MylayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MylayoutTheme {
                Mylayout()
            }
        }
    }
}

@Composable
fun Mylayout() {
    Column (modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text("TopBar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) { Text("Box1") }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) { Text("Box2") }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .background(Color.Blue),
                    contentAlignment = Alignment.Center
                ) { Text("Box3") }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .background(Color.Yellow),
                    contentAlignment = Alignment.Center
                ) { Text("Box4") }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Text("BottomBar")
        }
    }
}