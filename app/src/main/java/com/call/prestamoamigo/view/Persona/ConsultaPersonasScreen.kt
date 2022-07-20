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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.model.Persona


@Composable
fun ConsultaPersonasScreen(
    navHostController: NavHostController,
    personaViewModel: PersonaViewModel = hiltViewModel()
){

    /*fun getMontoFromPrestamos(personaID: Int): Double {
        return personaViewModel.getMontoFromPrestamos(personaID)
    }*/

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
                        persona -> RowPersonas(navHostController =  navHostController, persona = persona, persona.personaId/*, montoPrestamo = getMontoFromPrestamos(persona.personaId)*/
                    /*monto = persona.monto, concepto = persona.concepto*/)
                }
            }
        }
    }

}

@Composable
fun RowPersonas(navHostController: NavHostController, persona:Persona, id:Int/*, montoPrestamo:Double,*/ /*fechaUltimoPrestamo:String,*/
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {navHostController.navigate("DashBoard/$id") }
        .padding(16.dp)
        .background(color = Color(0xFF82D4BB))
    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp).padding(vertical = 5.dp)
            .background(color = Color(0xFF82D4BB))
            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(color = Color(0xFF82D4BB))
                    .padding(8.dp),

                ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth().padding(5.dp),

                ) {

                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = "${persona.nombre}",
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = "${persona.prestamosTotales}" + " Prestamos",
                        style = MaterialTheme.typography.body2,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                       /*Text(text = "$montoPrestamo")*/

                        /*Text(text = "$${pago.monto}")*/


                    }

                }
            }
        }
    }
}

