package com.call.prestamoamigo.view.Persona

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun ConsultaPersonasScreen(
    navHostController: NavHostController,
    personaViewModel: PersonaViewModel = hiltViewModel()
){

    val ScaffoldState = rememberScaffoldState()



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Personas")}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroPersonas")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        scaffoldState = ScaffoldState

    ) {it

        /*val state = personaViewModel.state.value
        Column(modifier = Modifier.fillMaxSize()) {
            val listapersonas = personaViewModel.personas.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(listapersonas.value){
                        deudor -> RowPrestamos(nombre = deudor.deudor, monto = deudor.monto, concepto = deudor.concepto)
                }
            }
        }*/
    }

}

/*@Composable
fun RowPersonas(nombre:String, monto:Double, cantidadPrestamos:Int, fechaUltimoPrestamo:String, *//*onClick : (CoinDto) -> Unit*//*
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { *//*onClick(coin)*//* }
        .padding(16.dp)
    ) {
        Text(
            text = "${nombre}",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(60.dp).padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${coin.valor}",
                color = Color.Green,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2,
            )
            Image(
                painter = rememberAsyncImagePainter(coin.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
            )
        }

    }
}*/
