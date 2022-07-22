package com.call.prestamoamigo.view.Pago

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.call.prestamoamigo.MyApp
import com.call.prestamoamigo.ui.theme.PrestamoAmigoTheme
import java.time.format.DateTimeFormatter
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegistroPagoScreen(
    navHostController: NavHostController,
    pagoViewModel: PagoViewModel = hiltViewModel(),
    personaIdentification: Int
    ) {

    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    val contexto = LocalContext.current

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    //validar
    var fechaValidar by remember { mutableStateOf(false)}
    var prestamoValidar by remember { mutableStateOf(false)}
    var conceptoValidar by remember { mutableStateOf(false)}
    var montoValidar by remember { mutableStateOf(false)}
    var prestamoIdValidar by remember { mutableStateOf(false)}

    val date = DatePickerDialog(
        contexto, {d, year, month, day->
        val month = month + 1
            pagoViewModel.fecha = "$day / $month / $year"
        },year, month, day
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Pagos") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    fechaValidar = pagoViewModel.fecha.isBlank()
                    prestamoValidar = pagoViewModel.selectedPrestamo.isBlank()
                    conceptoValidar = pagoViewModel.concepto.isBlank()
                    montoValidar = pagoViewModel.monto.isBlank()
                    prestamoIdValidar = pagoViewModel.selectId.toString().isBlank()


                    if(pagoViewModel.fecha.toString() == ""){
                        Toast.makeText(context, "Fecha no debe estar vacio", Toast.LENGTH_SHORT).show()
                    }

                    if(pagoViewModel.selectedPrestamo.toString() == ""){
                        Toast.makeText(context, "Debe selecionar un prestamo", Toast.LENGTH_SHORT).show()
                    }

                    if(pagoViewModel.concepto.toString() == ""){
                        Toast.makeText(context, "Concepto no debe estar vacio", Toast.LENGTH_SHORT).show()
                    }

                    if(pagoViewModel.monto.toString() == ""){
                        Toast.makeText(context, "Monto no debe estar vacio", Toast.LENGTH_SHORT).show()
                    }

                    if(!fechaValidar && !prestamoValidar && !conceptoValidar && !montoValidar && !prestamoIdValidar){
                        if(pagoViewModel.monto.toFloat() > 0){
                            pagoViewModel.Guardar()
                            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
                            navHostController.navigate("consultaPago/$personaIdentification")
                        }else{
                            Toast.makeText(context, "El Monto debe de ser mayor a 0", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Guardar")
            }
        },
        scaffoldState = ScaffoldState
    ) {
        it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)) {

                TextField(
                    value = pagoViewModel.fecha,
                    onValueChange = {pagoViewModel.fecha = it},
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Fecha")},
                    readOnly = true,
                    leadingIcon = {
                        IconButton(onClick = { date.show() }) {
                            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = "Guardar")
                        }
                    }

                )
            }

            ExposedDropdownMenuBox(
                expanded = pagoViewModel.expanded,
                onExpandedChange = {
                    pagoViewModel.expanded = it
                },
            ) {
                TextField(
                    readOnly = true,
                    value = pagoViewModel.selectedPrestamo,
                    onValueChange = { pagoViewModel.selectedPrestamo = it },
                    label = { Text(text = "Prestamo") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = pagoViewModel.expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.MoneyOff, contentDescription = "Guardar")
                    }
                )

                ExposedDropdownMenu(
                    expanded = pagoViewModel.expanded,
                    onDismissRequest = {
                        pagoViewModel.expanded = false
                    }
                ) {

                    val lista = pagoViewModel.prestamosPersonas.collectAsState(initial = emptyList())

                    lista.value.forEach() { selectPrestamos ->
                        DropdownMenuItem(
                            onClick = {
                                pagoViewModel.selectedPrestamo = selectPrestamos.concepto
                                pagoViewModel.selectId = selectPrestamos.prestamoId
                                pagoViewModel.selectmonto = selectPrestamos.monto.toDouble()
                                pagoViewModel.expanded = false
                            }
                        ) {
                            Text(text = selectPrestamos.concepto)
                        }
                    }
                }
            }
            TextField(
                    value = pagoViewModel.concepto,
            onValueChange = {pagoViewModel.concepto = it},
            label = { Text(text = "Concepto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null)
                }
            )

            TextField(
                value = pagoViewModel.selectmonto.toString(),
                onValueChange = {pagoViewModel.selectmonto},
                readOnly = true,
                label = { Text(text = "Monto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Money,
                        contentDescription = null)
                }
            )
        }
    }
}



