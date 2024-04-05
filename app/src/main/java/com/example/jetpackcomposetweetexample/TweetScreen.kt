package com.example.jetpackcomposetweetexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetweetexample.ui.theme.JetpackComposeTweetExampleTheme

@Composable
fun TweetScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Avatar(Modifier.align(Alignment.TopStart))
    }
}

@Composable
fun Avatar(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.mewtwo),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = modifier.size(64.dp).clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun TweetScreenPreview() {
    JetpackComposeTweetExampleTheme {
        TweetScreen()
    }
}