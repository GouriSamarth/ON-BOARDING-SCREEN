package com.example.on_boarding_screen

import android.graphics.Paint.Style
import android.os.Bundle
import android.icu.text.CaseMap.Title

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import com.example.on_boarding_screen.ui.theme.ONBOARDINGSCREENTheme

import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ONBOARDINGSCREENTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    onBoardingScreen()

                }
            }
        }
    }
}



val onBoarding = listOf(
    Items("Shopping", "https://st.depositphotos.com/1001599/60727/v/450/depositphotos_607279986-stock-illustration-shopping-baby-isolated-cartoon-vector.jpg", "This is the best place where you can shop with good rates."),
    Items("Grocery", "https://img.freepik.com/premium-vector/buy-food-online-farm-market-shop-illustration-cartoon-happy-characters-buying-organic-vegetables-fruits-farmers-store-background_213110-432.jpg", " Fresh fruits and vegetables from the farms and gardens."),
    Items("Kitchenware", "https://img.freepik.com/premium-vector/young-good-looking-man-cooking-vegetables-illustration-flat-design-cartoon-style-man-kitchen-concept-stay-home-doing-domestic-chores_241153-1.jpg?size=626&ext=jpg&ga=GA1.1.1413502914.1696377600&semt=ais", "Here we have best kitchenware for you kitchen.")

)




