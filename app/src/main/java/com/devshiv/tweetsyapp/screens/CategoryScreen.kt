package com.devshiv.tweetsyapp.screens

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devshiv.tweetsyapp.R
import com.devshiv.tweetsyapp.viewmodels.CategoryViewModel


@Composable
fun CategoryScreen( onClick: (category:String) -> Unit) {
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()

    Column {
        Text(
            text = "Categories",
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(categories.value.distinct()) {
                CategoryItem(category = it, onClick)
            }
        }
    }
}

@Composable
fun CategoryItem(category: String, onClick: (category:String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onClick(category)
            }
    ) {
        Column() {
            Image(
                imageVector = Icons.Filled.Category, contentDescription = "Category Img",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(10.dp)
                    .size(60.dp),
                colorFilter = ColorFilter.tint(Color.DarkGray)
            )
            Text(
                text = category.uppercase(),
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth(1f)
                    .padding(4.dp)
            )
        }
    }
}