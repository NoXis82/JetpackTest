package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import ru.umarsh.jetpackcomposeapptest.AppBar
import ru.umarsh.jetpackcomposeapptest.DrawerBody
import ru.umarsh.jetpackcomposeapptest.DrawerHeader
import ru.umarsh.jetpackcomposeapptest.dto.MenuItem
import ru.umarsh.jetpackcomposeapptest.ui.NavigationDrawerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerComposeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(items = listOf(
                            MenuItem(
                                id = "home",
                                title = "Home",
                                contentDescription = "go to home",
                                icon = Icons.Default.Home
                            ),
                            MenuItem(
                                id = "settings",
                                title = "Settings",
                                contentDescription = "go to settings",
                                icon = Icons.Default.Settings
                            ),
                            MenuItem(
                                id = "help",
                                title = "Help",
                                contentDescription = "go to help",
                                icon = Icons.Default.Info
                            )
                        ), onItemClick = {
                            println(">>> Clickable: ${it.title}")
                        })
                    }, drawerGesturesEnabled = scaffoldState.drawerState.isOpen) {

                }
            }
        }
    }
}
