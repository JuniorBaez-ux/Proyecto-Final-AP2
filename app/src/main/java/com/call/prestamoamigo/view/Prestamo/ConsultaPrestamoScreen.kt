package com.call.prestamoamigo.view.Prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun ConsultaPersonasScreen(
    navHostController: NavHostController,
    PrestamoViewModel: PrestamoViewModel = hiltViewModel()
){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Listado de Prestamos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroPrestamos")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        scaffoldState = ScaffoldState

    ) {it

        Column(modifier = Modifier.padding(8.dp)
            .fillMaxSize()) {

            }
        }
}

