@file:OptIn(ExperimentalPermissionsApi::class)

package ru.umarsh.jetpackcomposeapptest

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

fun PermissionState.isPermanentlyDenied(): Boolean {
    return !this.hasPermission && !this.shouldShowRationale
}