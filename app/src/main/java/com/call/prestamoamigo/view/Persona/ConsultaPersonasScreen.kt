package com.call.prestamoamigo.view.Persona

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
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
        Column(modifier = Modifier.fillMaxSize()) {
            val listapersonas = personaViewModel.personas.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(listapersonas.value){
                        persona -> RowPersonas(navHostController =  navHostController, nombre = persona.nombre, persona.personaId,
                    /*monto = persona.monto, concepto = persona.concepto*/)
                }
            }
        }
    }

}

@Composable
fun RowPersonas(navHostController: NavHostController, nombre:String, id:Int/*monto:Double, cantidadPrestamos:Int, fechaUltimoPrestamo:String,*/
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {navHostController.navigate("DashBoard/$id") }
        .padding(16.dp)
        .background(color = Color(0xFF82D4BB))
    ) {
/*
        Text(
            text = "${nombre}",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis
        )
*/

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(60.dp).padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
              Text(
            text = "${nombre}",
            style = MaterialTheme.typography.h5,
            overflow = TextOverflow.Ellipsis,
            color = Color.Black
        )
          /*  Image(
                painter = rememberAsyncImagePainter(coin.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
            )*/
        }

    }
}