package com.call.prestamoamigo.view.Pago

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ConsultaPagoScreen(
    navHostController: NavHostController,
    pagoViewModel: PagoViewModel = hiltViewModel()
){
    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta de Pago") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("registroPago")
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Guardar")
            }
        },
        scaffoldState = ScaffoldState
    ) {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {


        }
    }
}