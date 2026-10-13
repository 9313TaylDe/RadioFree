package com.example.radiofree.app.ui

import android.media.browse.MediaBrowser
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import coil3.compose.AsyncImage
import com.example.radiofree.app.data.classes.RadioStation
import com.example.radiofree.app.data.viewmodel.ViewModelClass
import kotlin.math.log

@Composable
fun CardRadio(
    viewModelClass: ViewModelClass,
    radios: List<RadioStation>,
    modifier: Modifier = Modifier
) {
    val rdios by viewModelClass.radios.collectAsState()
    val context = LocalContext.current
    val player by remember { mutableStateOf(ExoPlayer.Builder(context).build()) }
    val playing by viewModelClass.playing.collectAsState()
    val isFavorites by viewModelClass.isFavorite.collectAsState()
    val favorite by viewModelClass.favorites.collectAsState()
    DisposableEffect(player) {
        val listener = object : androidx.media3.common.Player.Listener {

            override fun onPlaybackStateChanged(playbackState: Int) {
                android.util.Log.d(
                    "RadioFree",
                    "Estado do player: $playbackState"
                )
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                android.util.Log.d(
                    "RadioFree",
                    "Está reproduzindo: $isPlaying"
                )
            }

            override fun onPlayerError(
                error: androidx.media3.common.PlaybackException
            ) {
                android.util.Log.e(
                    "RadioFree",
                    "Falha: ${error.errorCodeName}",
                    error
                )
            }
        }

        player.addListener(listener)

        onDispose {
            player.removeListener(listener)
            player.release()
        }
    }

    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = radios, key = { it.stationUuid }) { radio ->


            val isPlaying = radio.stationUuid == playing
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(7.dp)
                    .clip(RoundedCornerShape(20.dp)),

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = radio.favicon,
                        contentDescription = radio.name,
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp)
                            .clip(
                                RoundedCornerShape(60.dp)
                            )

                    )
                    Text(
                        text = radio.name,
                        maxLines = 2,
                        color = Color.Blue,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )


                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        IconButton(
                            onClick = {
                                if (isPlaying) {
                                    Toast.makeText(
                                        context,
                                        "Rádio pausada: ${radio.name}", Toast.LENGTH_SHORT
                                    ).show()
                                    player.pause()
                                    viewModelClass.setPlayingStationUiid(null)
                                } else {
                                    val url = radio.url.ifBlank {
                                        radio.url
                                    }

                                    if (url.isBlank()) {
                                        Toast.makeText(
                                            context, "URL não disponivel", Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        try {
                                            val radioItem = MediaItem.Builder()
                                                .setUri(radio.urlResolved?.ifBlank { radio.url })
                                                .setMediaId(radio.stationUuid)
                                                .build()
                                            player.setMediaItem(radioItem)
                                            viewModelClass.setPlayingStationUiid(radio.stationUuid)
                                            Toast.makeText(
                                                context,
                                                "Reproduzindo: ${radio.name}", Toast.LENGTH_SHORT
                                            ).show()
                                            player.prepare()
                                            player.play()
                                        } catch (e: Exception) {
                                            Toast.makeText(
                                                context,
                                                "Erro ao reproduzir", Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }

                                }
                            }) {

                            Icon(
                                imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayCircle,
                                contentDescription = if (isPlaying) "pausar" else "tocar",
                                modifier = Modifier.size(40.dp),
                                tint = MaterialTheme.colorScheme.onBackground
                            )

                        }
                        val isfavorites = favorite.any {
                            it.stationUuid == radio.stationUuid
                        }
                        IconButton(onClick = {
                            if (!isfavorites) {
                                viewModelClass.addAosFavoritos(radio)
                            } else {
                                viewModelClass.deletarDosFavoritos(radio.stationUuid)
                            }
                        }) {
                            Icon(
                                imageVector = if (isfavorites) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Adicionar aos favoritos",
                                modifier = Modifier.size(40.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}


