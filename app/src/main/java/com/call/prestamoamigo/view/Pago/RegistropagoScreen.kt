package com.call.prestamoamigo.view.Pago

import android.content.Context
import android.widget.DatePicker
import android.widget.Spinner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAs
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegistroPagoScreen(
    navHostController: NavHostController,
    pagoViewModel: PagoViewModel = hiltViewModel()) {

    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Pago") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
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

            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Fecha")}
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
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
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
                    value = "",
            onValueChange = {},
            label = { Text(text = "Concepto") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Monto") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
            )
        }




    }
}



