package com.example.radiofree.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.radiofree.app.data.viewmodel.ViewModelClass

@Composable
fun ScreenHome(
    viewModelClass: ViewModelClass
) {
    val radios by viewModelClass.radios.collectAsState()
    var pesquisados by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<String?>(null) }

    val filtrados = when {
        selected != null -> {
            radios.filter {
                it.stationUuid == selected
            }
        }

        pesquisados.isNotEmpty() -> {
            radios.filter {
                it.name.contains(pesquisados.trim(), ignoreCase = true)
            }
        }

        else -> {
            radios
        }

    }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TextField(
                value = pesquisados,
                onValueChange = {
                    pesquisados = it
                    selected = null
                    expanded = it.isNotEmpty()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFF64B5F6).copy(alpha = 0.20f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                placeholder = {
                    Text("Pesquisar", color = Color.Black)
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, "Pesquisar"
                    )
                },
                trailingIcon = {
                    if (pesquisados.isNotEmpty()) {
                        IconButton(onClick = {
                            pesquisados = ""
                            expanded = false
                            selected = null

                        }) {
                            Icon(
                                imageVector = Icons.Default.Close, "limpar pesquisa"
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0xFF64B5F6),

                    )
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                filtrados.forEach { filtracao ->
                    DropdownMenuItem(
                        text = {
                            Text(filtracao.name)
                        },
                        onClick = {
                            selected = filtracao.stationUuid
                            pesquisados = ""
                            expanded = false
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Estações encontradas: ${radios.size}",
                color = Color.Red
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            CardRadio(
                viewModelClass = viewModelClass,
                radios = filtrados,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}