package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import ru.umarsh.jetpackcomposeapptest.R
import ru.umarsh.jetpackcomposeapptest.ui.MotionLayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotionLayoutComposeTheme {
                Column {
                    var progress by remember {
                        mutableStateOf(0f)
                    }
                    ProfileHeader(progress = progress)
                    Spacer(modifier = Modifier.height(32.dp))
                    Slider(value = progress, onValueChange = {
                        progress = it
                    }, modifier = Modifier.padding(horizontal = 32.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileHeader(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scene).readBytes().decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        val properties = motionProperties(id = "profile_pic")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )
        Image(
            painter = painterResource(id = R.drawable.android), contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .border(2.dp, properties.value.color("background"), CircleShape)
                .layoutId("profile_pic")
        )
        Text(
            text = "Vyacheslav Tumanov",
            fontSize = 24.sp,
            modifier = Modifier.layoutId("username"),
            color = properties.value.color("background")
        )
    }
}