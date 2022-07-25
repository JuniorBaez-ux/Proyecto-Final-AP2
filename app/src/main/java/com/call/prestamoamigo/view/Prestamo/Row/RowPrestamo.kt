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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.call.prestamoamigo.model.Prestamo


@Composable
fun RowPrestamo (prestamo: Prestamo, navHostController: NavHostController,
                 personaIdentification: Int)
{

    Column(modifier = Modifier
        .fillMaxWidth().padding(16.dp)
        .background(color = Color(0xFF82D4BB)))
        {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp).padding(vertical = 5.dp)

            .clickable {
                navHostController.navigate("RegistroPrestamo/$personaIdentification")
            }
            , backgroundColor = MaterialTheme.colors.primary){
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
                        text = "${prestamo.concepto}",
                        style = MaterialTheme.typography.body1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        )

                    Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text= "$${prestamo.monto}",
                            style = MaterialTheme.typography.body2,
                            overflow = TextOverflow.Ellipsis,
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
                )
                    {
                        Text(modifier = Modifier.padding(vertical = 5.dp),
                            text= "${prestamo.fecha}",
                            style = MaterialTheme.typography.body2,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold)

                        Text(
                            text = if(prestamo.activo == 0) "No pagado" else "Pagado",
                                style = MaterialTheme.typography.body2,
                                overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }