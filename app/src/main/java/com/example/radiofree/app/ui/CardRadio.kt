package com.example.radiofree.app.ui

import android.media.browse.MediaBrowser
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    viewModelClass: ViewModelClass
) {
    val rdios by viewModelClass.radios.collectAsState()
    val context = LocalContext.current
    val player by remember { mutableStateOf(ExoPlayer.Builder(context).build()) }
    val playing by viewModelClass.playing.collectAsState()
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

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        rdios.forEach { radiosState ->
            val isPLyaing = radiosState.stationUuid == playing
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier.fillMaxWidth(0.5f)) {
                    AsyncImage(
                        model = radiosState.favicon,
                        contentDescription = radiosState.name,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = radiosState.name,
                        maxLines = 2,
                        color = Color.Blue,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                }
                if (isPLyaing) {
                    IconButton(onClick = {
                        player.pause()
                        viewModelClass.setPlayingStationUiid(null)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Pause, ""
                        )
                    }
                } else {
                    IconButton(onClick = {
                        android.util.Log.e("RadioFree", "1 - Clique no Play")

                        try {
                            android.util.Log.e("RadioFree", "2 - Criando MediaItem")
                            android.util.Log.d(
                                "RadioFree",
                                "Rádio: ${radiosState.name} | URL: ${radiosState.urlResolved}"
                            )
                            val item = MediaItem.Builder()
                                .setUri(radiosState.urlResolved.ifBlank { radiosState.url })
                                .setMediaId(radiosState.stationUuid)
                                .build()

                            android.util.Log.e("RadioFree", "3 - Definindo mídia")
                            player.setMediaItem(item)
                            viewModelClass.setPlayingStationUiid(radiosState.stationUuid)

                            android.util.Log.e("RadioFree", "4 - Preparando player")
                            player.prepare()

                            android.util.Log.e("RadioFree", "5 - Iniciando reprodução")
                            player.play()

                            android.util.Log.e("RadioFree", "6 - Play executado")
                            Toast.makeText(
                                context,
                                "Reproduzindo: ${radiosState.name}",
                                Toast.LENGTH_LONG
                            ).show()

                        } catch (e: Exception) {
                            android.util.Log.e(
                                "RadioFree",
                                "ERRO NO CLIQUE",
                                e
                            )
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.PlayCircle,
                            modifier = Modifier.size(50.dp),
                            tint = Color.Blue,
                            contentDescription = "Tocar: ${radiosState.name}"
                        )
                    }
                }
            }
        }
    }
}
