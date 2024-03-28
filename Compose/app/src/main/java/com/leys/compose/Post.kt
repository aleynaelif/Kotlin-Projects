package com.leys.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.leys.compose.ui.theme.Beige

@Composable
fun Post() {
    // Create a Box that fills the entire screen.
    Box(modifier = Modifier.fillMaxSize()) {
        // Create a Column that fills the entire screen and is aligned to the center.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            // Set the vertical and horizontal alignment of the children of the Column.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Create a Text object with the text "Post", a font size of 30sp, and a color of Beige.
            Text(text = "Post", fontSize = 30.sp, color = Beige)
        }
    }
}

@Preview
@Composable
fun PostPreview(){
    Post()
}