package com.call.prestamoamigo.view.Pago

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Spinner
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
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
    pagoViewModel: PagoViewModel = hiltViewModel()) {

    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    val contexto = LocalContext.current

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

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
                    pagoViewModel.Guardar()
                    navHostController.navigate("consultaPago")
                },
                backgroundColor = MaterialTheme.colors.primary
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
                    value = pagoViewModel.selectedOptionText,
                    onValueChange = { pagoViewModel.selectedOptionText = it },
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
                    pagoViewModel.options.forEach { selectPrestamos ->
                        DropdownMenuItem(
                            onClick = {
                                pagoViewModel.selectedOptionText = selectPrestamos
                                pagoViewModel.expanded = false
                            }
                        ) {
                            Text(text = selectPrestamos)
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
                value = pagoViewModel.monto,
                onValueChange = {pagoViewModel.monto = it},
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



