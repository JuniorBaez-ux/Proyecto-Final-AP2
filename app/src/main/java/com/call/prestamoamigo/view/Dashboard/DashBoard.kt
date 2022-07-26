package com.call.prestamoamigo.view.Dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun DashBoard (navHostController: NavHostController,personaIdentification:
Int, prestamosTotalesDelCliente: Int
, nombrePersona: String,  telefonoPersona: String,  correoPersona: String,  direccionPersona: String) {

    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Dashboard") })
        },

        scaffoldState = ScaffoldState
    ) {
        it
        Column(

            modifier = Modifier
                .fillMaxWidth().fillMaxHeight()
                .padding(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(vertical = 5.dp),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFF82D4BB)),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {

                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = "$nombrePersona",
                            style = MaterialTheme.typography.body1,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = "$telefonoPersona",
                            style = MaterialTheme.typography.body2,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color(0xFF82D4BB)),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = "$correoPersona",
                            style = MaterialTheme.typography.body1,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = "$direccionPersona",
                            style = MaterialTheme.typography.body2,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }


            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                OutlinedButton(
                    onClick = { navHostController.navigate("ConsultaPrestamo/$personaIdentification") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent),

                    ) {
                    Text(
                        text = "Prestamo",
                        color = Color.Black
                    )
                }
                OutlinedButton(
                    onClick = { navHostController.navigate("ConsultaPago/$personaIdentification") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent)
                ) {
                    Text(
                        text = "Pagar",
                        color = Color.Black
                    )
                }
            }


        }
    }
}