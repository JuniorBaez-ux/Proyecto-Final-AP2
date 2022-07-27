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
import androidx.compose.runtime.*
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
import com.call.prestamoamigo.model.Pago
import com.call.prestamoamigo.model.Persona
import com.call.prestamoamigo.ui.theme.backgroundColor
import com.call.prestamoamigo.ui.theme.primaryColor
import kotlinx.coroutines.flow.Flow


@Composable
fun ConsultaPersonasScreen(
    navHostController: NavHostController,
    personaViewModel: PersonaViewModel = hiltViewModel()
){
    val ScaffoldState = rememberScaffoldState()

    //Esta funcion se encarga de obtener el balance total de la base de datos
    //Siempre y cuando cumpla con los requisitos establecidos
    fun getMontoFromPrestamos(personaId: Int?, prestamosTotales: Int?) : Double{
        var montoDelPrestamo by mutableStateOf(0.0)
        if (prestamosTotales!= 0){
            montoDelPrestamo = personaViewModel.GetMontoPrestamo(personaId)
            return montoDelPrestamo
        }else{
            return 0.0
        }
    }

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
                    persona -> RowPersonas(navHostController =  navHostController, persona = persona, persona.personaId,
                    persona.nombre, persona.telefono, persona.correo, persona.direccion, persona.prestamosTotales,
                    montoPrestamo = getMontoFromPrestamos(persona.personaId, persona.prestamosTotales),
                    fechaUltimoPrestamo = personaViewModel.GetFechas(persona.personaId))
                }
            }
        }
    }

}

@Composable
fun RowPersonas(navHostController: NavHostController, persona:Persona, id:Int, nombre:String, telefono:String,
                correo:String, direccion:String, prestamosTotales:Int, montoPrestamo:Double,
                fechaUltimoPrestamo:String
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {navHostController.navigate("DashBoard/$id/$nombre/$telefono/$correo/$direccion/$prestamosTotales") }
        .padding(16.dp)

    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp).padding(vertical = 5.dp)
            , backgroundColor = MaterialTheme.colors.primary
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF82D4BB))
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
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
                        text = "$montoPrestamo",
                        style = MaterialTheme.typography.body2,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF82D4BB))
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = "${persona.prestamosTotales}" + " Prestamos",
                        style = MaterialTheme.typography.body2,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = "$fechaUltimoPrestamo",
                        style = MaterialTheme.typography.body2,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

