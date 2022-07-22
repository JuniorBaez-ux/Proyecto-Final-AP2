package com.call.prestamoamigo.view.Pago

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.model.Pago

@Composable
fun ConsultaPagoScreen(
    navHostController: NavHostController,
    pagoViewModel: PagoViewModel = hiltViewModel(),
    personaIdentification: Int
){
    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Pagos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("registroPago/$personaIdentification")
                },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, )

            }
        },
        scaffoldState = ScaffoldState
    ) {it

        val listaPago = pagoViewModel.pagos.collectAsState(initial = emptyList())

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(listaPago.value){ pagos ->
                    pagoItem(pago = pagos, onClick = {})
                }
            }
        }
    }
}

@Composable
fun pagoItem(pago: Pago, onClick : (Pago)->Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)
    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp).padding(vertical = 5.dp)
            .clickable { onClick(pago) },
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(8.dp),

                ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth().padding(2.dp)

                ) {

                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = "${pago.concepto}",
                        style = MaterialTheme.typography.body1,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                        Text(text = "${pago.fecha}",)

                        Text(text = "$${pago.monto}")


                    }

                }
            }
        }
    }
}

