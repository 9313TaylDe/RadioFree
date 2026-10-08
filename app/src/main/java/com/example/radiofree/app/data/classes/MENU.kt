package com.example.radiofree.app.data.classes

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.radiofree.R

enum class MENU(
    val title: String, val rota: String, val icon: ImageVector
) {
    HOME(title = "HOME", rota = "", Icons.Default.Home),
    ABOUT("ABOUT","", Icons.Default.Info),
    SETINGS("SETTINGS", "", Icons.Default.Settings),
}
