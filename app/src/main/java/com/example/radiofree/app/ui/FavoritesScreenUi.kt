package com.example.radiofree.app.ui

import android.widget.GridLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.radiofree.app.data.viewmodel.ViewModelClass

@Composable
fun FavoritesScreenUi(viewModelClass: ViewModelClass) {
    val favorites by viewModelClass.isFavorite.collectAsState()

    if (favorites.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Adicione favoritos",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(favorites) { favorites ->

                Card() {
                    AsyncImage(
                        model = favorites.favicon,
                        contentDescription = "ícone da esatacao", modifier = Modifier.size(
                            60.dp
                        )
                    )
                    Text("Título: ${favorites.name}")
                    Text(
                        "Idioma: ${favorites.language}"
                    )
                    Text(
                        "País: ${favorites.country}"
                    )
                }
            }
        }
    }
}