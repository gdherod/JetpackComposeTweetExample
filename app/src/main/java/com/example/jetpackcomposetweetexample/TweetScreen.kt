package com.example.jetpackcomposetweetexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetweetexample.ui.theme.JetpackComposeTweetExampleTheme

@Composable
fun TweetScreen() {
    var chat by remember {
        mutableStateOf(false)
    }
    var rt by remember {
        mutableStateOf(false)
    }
    var like by remember {
        mutableStateOf(false)
    }
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
                    tint = Color.White,
                    modifier = Modifier.padding(start = 100.dp)
                )
            }
            TextBody(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
                        + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
                        + "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                Modifier.padding(bottom = 16.dp)
            )

            PostImage()

            Row(Modifier.padding(top = 16.dp)) {
                SocialIcons(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat),
                            contentDescription = "chat icon",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "chat icon filled",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }

                SocialIcons(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "rt icon",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "rt icon",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }

                SocialIcons(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like),
                            contentDescription = "like icon",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "like icon filled",
                            tint = Color(0xFFFF0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }
    }
}

@Composable
fun TweetDivider() {
    Divider(
        Modifier
            .padding(top = 4.dp)
            .height(0.8.dp)
            .fillMaxWidth(), color = Color(0xFF7E8B98)
    )
}

@Composable
fun SocialIcons(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {

    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
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