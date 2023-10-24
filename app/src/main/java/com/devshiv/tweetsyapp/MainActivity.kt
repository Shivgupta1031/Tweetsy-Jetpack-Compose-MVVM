package com.devshiv.tweetsyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devshiv.tweetsyapp.api.TweetsyApi
import com.devshiv.tweetsyapp.screens.CategoryScreen
import com.devshiv.tweetsyapp.screens.DetailScreen
import com.devshiv.tweetsyapp.ui.theme.TweetsyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG: String = "MyTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsyAppTheme {
                AppUI()
            }
        }
    }
}

@Composable
fun AppUI() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Category") {
        composable(route = "Category") {
            CategoryScreen{
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            DetailScreen(

            )
        }
    }
}