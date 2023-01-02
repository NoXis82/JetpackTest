package ru.umarsh.jetpackcomposeapptest.activity

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import ru.umarsh.jetpackcomposeapptest.isPermanentlyDenied
import ru.umarsh.jetpackcomposeapptest.ui.PermissionHandlingComposeTheme

@OptIn(ExperimentalPermissionsApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionHandlingComposeTheme {
                val permissionState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA
                    )
                )
                val lifecycleOwner = LocalLifecycleOwner.current
                DisposableEffect(key1 = lifecycleOwner, effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_START) {
                            permissionState.launchMultiplePermissionRequest()
                        }
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                })

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    permissionState.permissions.forEach { permissionState ->
                        when (permissionState.permission) {
                            Manifest.permission.RECORD_AUDIO -> {
                                when {
                                    permissionState.hasPermission -> {
                                        Text(text = "Record audio permission accepted\n")
                                    }
                                    permissionState.shouldShowRationale -> {
                                        Text(text = "Record audio permission is needed to access the micro\n")
                                    }
                                    permissionState.isPermanentlyDenied() -> {
                                        Text(
                                            text = "Record audio permission was permanently denied." +
                                                    "You can enable it in the app settings.\n"
                                        )
                                    }
                                }
                            }
                            Manifest.permission.CAMERA -> {
                                when {
                                    permissionState.hasPermission -> {
                                        Text(text = "Camera permission accepted\n")
                                    }
                                    permissionState.shouldShowRationale -> {
                                        Text(text = "Camera permission is needed to access the camera\n")
                                    }
                                    permissionState.isPermanentlyDenied() -> {
                                        Text(
                                            text = "Camera permission was permanently denied." +
                                                    "You can enable it in the app settings.\n"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
