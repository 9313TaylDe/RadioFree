package com.example.radiofree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.radiofree.app.connection.ApiConection
import com.example.radiofree.app.connection.ApiResponde
import com.example.radiofree.app.data.appdatabase.AppDataBase
import com.example.radiofree.app.data.appdatabase.Repository
import com.example.radiofree.app.data.dao.RadioStatesDAO
import com.example.radiofree.app.data.viewmodel.ViewModelClass
import com.example.radiofree.app.data.viewmodel.ViewModelFactorys
import com.example.radiofree.app.ui.MenuMobile
import com.example.radiofree.app.ui.ScreenHome
import com.example.radiofree.ui.theme.RadioFreeTheme
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val database = Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java,
                "db"
            ).build()
            val appDataBase = database.radiostates()

            val repositoy = Repository(
                apiResponde = ApiConection.api,
                radioStatesDAO = appDataBase
            )
            val factory = ViewModelFactorys(repositoy)
            val viewModelClass: ViewModelClass = viewModel(
                factory = factory
            )
            MenuMobile(
                viewModelClass = viewModelClass
            ) {
                ScreenHome(
                    viewModelClass = viewModelClass
                )
            }

        }
    }
}
