package ru.umarsh.jetpackcomposeapptest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.umarsh.jetpackcomposeapptest.ui.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            mainViewModel.items.forEach { personalItem ->
                DragTarget(dataToDrop = personalItem, viewModel = mainViewModel) {
                    Box(
                        modifier = Modifier
                            .size(Dp(screenWidth / 5f))
                            .clip(RoundedCornerShape(10.dp))
                            .shadow(5.dp, RoundedCornerShape(10.dp))
                            .background(personalItem.backgroundColor, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = personalItem.name)
                    }
                }

            }

        }

        AnimatedVisibility(
            visible = mainViewModel.isCurrentlyDragging,
            enter = slideInHorizontally(initialOffsetX = { it })
        ) {
            DropItem<PersonalItem>(
                modifier = Modifier.size(Dp(screenWidth / 3.5f))
            ) { isInBound, data ->
                if (data != null) {
                    LaunchedEffect(key1 = data) {
                        mainViewModel.addPerson(data)
                    }
                }
                if (isInBound) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(1.dp, Color.Red, RoundedCornerShape(10.dp))
                            .background(Color.Green.copy(alpha = 0.5f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Add personal")
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Add personal")
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "Added Personal")
                mainViewModel.addedPersonals.forEach {
                    Text(text = it.name)
                }
            }
        }

    }

}