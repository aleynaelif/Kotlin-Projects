package com.leys.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    LearnTextAndModifiers()
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
        modifier = Modifier.padding(16.dp).background(Color.Yellow).clickable(onClick = clickOnText)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        LearnTextAndModifiers()
    }
}

