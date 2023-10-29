package com.example.on_boarding_screen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen() {
    val pager = rememberPagerState()
    val list = onBoarding
    val Next = remember {
        derivedStateOf { pager.currentPage!= list.size-1 }
    }

    val Previous = remember {
        derivedStateOf { pager.currentPage!= 0 }
    }

    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.background(Color.White)
    )
    {
        HorizontalPager(pageCount = list.size, state = pager) {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(6.dp) ){
                Row (modifier = Modifier.padding(5.dp)){
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Exit", modifier = Modifier.padding(start = 2.dp), style = TextStyle(fontSize = 17.sp))

                    }
                    Spacer(modifier = Modifier.fillMaxWidth(.8f))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Skip", modifier = Modifier.padding() , style = TextStyle(fontSize = 17.sp))

                    }
                }
                Text(
                    text = list[pager.currentPage].title,
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(fontSize = 50.sp, textAlign = TextAlign.Center,)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(list[pager.currentPage].image).build(),
                    contentDescription = null, modifier = Modifier
                        .size(500.dp)
                        .padding(start = 4.dp)
                )
                Text(
                    text = list[pager.currentPage].description,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 20.sp,)
                )
                Spacer(modifier = Modifier.padding(2.dp))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp), horizontalArrangement = Arrangement.Center
                ){
                    repeat(list.size){
                            hello->
                        val color = if (pager.currentPage == hello) Color.Blue else Color.LightGray

                        Box(modifier = Modifier
                            .padding(5.dp)
                            .clip(RectangleShape)
                            .background(color)
                            .size(19.dp))
                    }


                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 9.dp)) {
                    if (Previous.value)
                    {
                        TextButton(onClick = {scope.launch { pager.animateScrollToPage(pager.currentPage-1) } }) {
                            Text(text = "Previous", modifier = Modifier.padding(start = 15.dp), style = TextStyle(fontSize = 20.sp))

                        }
                    }
                    if (Previous.value&& Next.value){
                        Box(modifier = Modifier.fillMaxWidth(.7f))
                    }
                    if (Next.value){
                        TextButton(onClick = { scope.launch { pager.animateScrollToPage(pager.currentPage+1) }}) {
                            Text(text = "Next", modifier = Modifier.padding(start = 12.dp), style = TextStyle(fontSize = 20.sp))

                        }
                    }

                }








            }

        }


    }
}


