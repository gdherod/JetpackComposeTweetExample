package com.example.jetpackcomposetweetexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetweetexample.ui.theme.JetpackComposeTweetExampleTheme

@Composable
fun TweetScreen() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF161026))
            .padding(16.dp)

    ) {
        Avatar(modifier = Modifier)
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                TextTitle(title = "Gary", Modifier.padding(end = 8.dp))
                DefaultText(title = "@Garuxa", Modifier.padding(end = 8.dp))
                DefaultText(title = "4h", Modifier.padding(end = 8.dp))
                Icon(
                    painterResource(id = R.drawable.ic_dots),
                    contentDescription = "dots",
                    tint = Color.White
                )
            }
            TextBody(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
                        + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
                        + "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                Modifier.padding(bottom = 16.dp)
            )
            PostImage()
        }
    }
}

@Composable
fun PostImage() {
    Image(
        painter = painterResource(id = R.drawable.mewtwo),
        contentDescription = "post image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(
                RoundedCornerShape(10)
            ),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun Avatar(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.mewtwo),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(55.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun TweetScreenPreview() {
    JetpackComposeTweetExampleTheme {
        TweetScreen()
    }
}