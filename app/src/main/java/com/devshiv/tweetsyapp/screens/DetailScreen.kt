package com.devshiv.tweetsyapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devshiv.tweetsyapp.model.TweetListItem
import com.devshiv.tweetsyapp.viewmodels.DetailViewModel

@Composable
fun DetailScreen() {
    val viewModel: DetailViewModel = hiltViewModel()
    val tweets: State<List<TweetListItem>> = viewModel.tweets.collectAsState()

    Column {
        Text(
            text = "Tweets",
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn {
            items(tweets.value.distinct()) {
                TweetItem(tweet = it)
            }
        }
    }
}

@Composable
fun TweetItem(tweet: TweetListItem) {
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier.padding(4.dp).fillMaxWidth(1f)
    ) {
        Row() {
            Image(
                imageVector = Icons.Filled.Category, contentDescription = "Category Img",
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 6.dp, end = 6.dp)
                    .align(Alignment.CenterVertically),
                colorFilter = ColorFilter.tint(Color.DarkGray)
            )
            Text(
                text = tweet.text,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                color = Color.LightGray,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(5.dp)
            )
        }
    }
}