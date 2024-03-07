package com.leys.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leys.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    //LearnTextAndModifiers()
                    //LearnRowColumBox()
                }
            }
        }
    }
}
@Composable
fun LearnTextAndModifiers(){

    val clickOnText = {}

    Text(text = stringResource(R.string.hello_text),
        color = Color.Magenta,
        fontSize = 32.sp,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Yellow)
            .clickable(onClick = clickOnText)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        LearnTextAndModifiers()
    }
}

@Composable
fun LearnRowColumBox(){

    // Overlap
    Text(text = "Hello Column")
    Text(text = "Hello Row")
    Text(text = "Hello Box")


    //Column Layout
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Hello Column 1")
        Text(text = "Hello Column 2")
        Text(text = "Hello Column 3")
    }


    //Row Layout
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Hello Row 1")
        Text(text = "Hello Row 2")
        Text(text = "Hello Row 3")
    }


    //Box Layout
    Box (modifier = Modifier.fillMaxSize().background(Color.Magenta), contentAlignment = Alignment.Center){
        Box (modifier = Modifier.height(300.dp).width(300.dp).background(Color.Blue)){
            Text(text = "Hello Box 1",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }
}
