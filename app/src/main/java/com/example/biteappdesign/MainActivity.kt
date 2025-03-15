package com.example.biteappdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biteappdesign.ui.theme.BiteappdesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiteappdesignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = Color.Black)
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(alpha = 0.5f),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.map),
        contentDescription = null,
    )
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = modifier
                    .clip(shape = CircleShape)
                    .background(color = Color.White)
                    .padding(5.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = modifier
                        .clip(shape = CircleShape)
                        .background(color = Color.Gray.copy(alpha = 0.5f))
                        .padding(5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null
                    )
                }
                Spacer(modifier = modifier.width(10.dp))
                Text(text = "What tempts you today?")
            }
            Spacer(modifier = modifier.width(10.dp))
            Image(
                modifier = modifier
                    .clip(shape = CircleShape)
                    .size(50.dp),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
            )
        }
        Cards()
    }
}

@Composable
fun Cards() {
    val listItems = listOf(
        listOf("🍽", "restaurant"),
        listOf("🍩", "cafe"),
        listOf("🍺", "bar"),
        listOf("🏠", "hotel"),
        listOf("🏛", "museum")
    )

    val images = listOf(
        R.drawable.pexels1,
        R.drawable.pexels2,
        R.drawable.pexels3,
        R.drawable.pexels4,
        R.drawable.pexels5,
    )

    val tags = listOf(
        listOf("Authentic", "Italian", "Spaghetti"),
        listOf("Traditional", "Roman", "Pasta"),
        listOf("Handmade", "Neapolitan", "Gnocchi"),
        listOf("Classic", "Sicilian", "Lasagna"),
        listOf("Fresh", "Tuscan", "Ravioli")
    )

    Column(){
        LazyRow() {
            items(listItems) { item ->
                    Row(
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 5.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.White)
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    ) {
                        Text(text = item[0])
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = item[1])
                    }
                }
        }


        LazyRow {
            items(images) { outerIndex ->
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .background(color = Color.White)
                        .padding(10.dp)
                        .width(350.dp)
                ) {
                    Image(
                        painter = painterResource(id = outerIndex),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(25.dp))
                            .size(width = 350.dp, height = 235.dp)

                    )
                    Text(
                        text = "Tortilla",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 10.dp),
                    )
                    LazyRow (
                        modifier = Modifier.fillMaxWidth()
                    ){
                        items(tags[0]) { item ->
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 5.dp)
                                    .clip(shape = CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Black,
                                        shape = CircleShape
                                    )
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            { Text(text = item) }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Want to try")
                        }
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.button),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "Visited")
                        }
                    }
                }
            }
        }
    }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BiteappdesignTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Greeting(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }