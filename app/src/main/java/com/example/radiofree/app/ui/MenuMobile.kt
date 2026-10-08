package com.example.radiofree.app.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.radiofree.app.data.classes.MENU
import com.example.radiofree.app.data.viewmodel.ViewModelClass
import kotlinx.coroutines.launch
import okio.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuMobile(viewModelClass: ViewModelClass, content: @Composable () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val menu = MENU.entries
    val drawner = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val isLoading by viewModelClass.isLoading.collectAsState()
    val hasError by viewModelClass.hasError.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModelClass.pegarTodasAsEstacoesDeRadios()
    }

    ModalNavigationDrawer(
        drawerState = drawner,
        drawerContent = {
            ModalDrawerSheet {
                menu.forEach { menuitem ->
                    Text(text = menuitem.title)
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
            topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("RadioFree")
                        IconButton(
                            enabled = !isLoading,
                            onClick = {
                                viewModelClass.pegarTodasAsEstacoesDeRadios()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Recarregar estações"
                            )
                        }

                    }
                }, navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                drawner.open()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Abrir menu principal"
                        )
                    }
                }
            )
        }
        ) { innerPadding ->

            Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    content()

                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    if (hasError) {
                        Text(
                            text = "Erro ao carregar estações de rádio",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

        }
    }
}
