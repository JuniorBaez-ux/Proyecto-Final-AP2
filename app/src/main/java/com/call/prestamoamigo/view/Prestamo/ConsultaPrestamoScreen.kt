package com.call.prestamoamigo.view.Prestamo

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.view.Pago.pagoItem
import com.call.prestamoamigo.view.Prestamo.Row.RowPrestamo


@Composable
fun ConsultaPrestamoScreen(
    navHostController: NavHostController,
    PrestamoViewModel: PrestamoViewModel = hiltViewModel(),
    personaIdentification: Int

){
    val listaPrestamo = PrestamoViewModel.prestamos.collectAsState(initial = emptyList())
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Listado de Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroPrestamo/$personaIdentification")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        scaffoldState = ScaffoldState

    ) {
        it

        Column(
            modifier = Modifier.padding(8.dp)
                .fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(listaPrestamo.value){ prestamo ->
                    RowPrestamo(prestamo = prestamo, navHostController = navHostController, personaIdentification)
                    Spacer(modifier = Modifier.height(5.dp))
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}

