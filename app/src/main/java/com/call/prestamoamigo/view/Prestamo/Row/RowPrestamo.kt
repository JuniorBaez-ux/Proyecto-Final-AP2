package com.call.prestamoamigo.view.Prestamo.Row

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.call.prestamoamigo.model.Prestamo


@Composable
fun RowPrestamo (prestamo: Prestamo, navHostController: NavHostController,
                 personaIdentification: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
        .background(color = Color(0xFF82D4BB)))
        {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                navHostController.navigate("RegistroPrestamo/$personaIdentification")
            }){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(8.dp),

                ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                    Text(
                        text = "${prestamo.concepto}",
                    )
                        Text("$${prestamo.monto}")
                }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                        Text("${prestamo.fecha}",)
                        Text("$ ${prestamo.balance}",)
                    }
                }
            }
        }
    }
}