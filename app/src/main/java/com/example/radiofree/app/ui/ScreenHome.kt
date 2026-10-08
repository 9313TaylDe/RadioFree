package com.example.radiofree.app.ui

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.radiofree.app.data.viewmodel.ViewModelClass

@Composable
fun ScreenHome(
    viewModelClass: ViewModelClass
) {
    val languages by viewModelClass.languages.collectAsState()
    val radios by viewModelClass.radios.collectAsState()
    var serach by remember { mutableStateOf("") }
    val searchings by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)

        ) {
            SearchStation(
                viewModelClass = viewModelClass
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Estações encontradas: ${radios.size}",
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(20.dp))

                CardRadio(
                    viewModelClass = viewModelClass
                )
            }
        }
    }
}