package com.call.prestamoamigo.ui.components.prestamo

import android.app.DatePickerDialog
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.ui.theme.backgroundColor
import com.call.prestamoamigo.view.Prestamo.PrestamoViewModel
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

@Composable
fun RegistroPrestamoSceen(navHostController: NavHostController,
                          PrestamoViewModel: PrestamoViewModel = hiltViewModel()
){
    val context = LocalContext.current

    var erro by rememberSaveable { mutableStateOf(false)}
    val Monto = FocusRequester()
    val Concepto = FocusRequester()
    val Vence = FocusRequester()
    val Fecha = FocusRequester()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Prestamo") }) },
            floatingActionButton = {
                 FloatingActionButton(
                      onClick = {
                          if (PrestamoViewModel.fecha.isNullOrEmpty()) {

                              Toast.makeText(context, "Fecha no puede estar vacio!", Toast.LENGTH_LONG).show()
                              Fecha.requestFocus()
                              return@FloatingActionButton
                          }
                          if (PrestamoViewModel.vence.isNullOrEmpty()) {

                              Toast.makeText(context, "La fecha Vence está vacio!", Toast.LENGTH_LONG).show()
                              Vence.requestFocus()
                              return@FloatingActionButton
                          }
                          if (PrestamoViewModel.concepto.isNullOrEmpty()) {
                              Toast.makeText(context, "El campo Concepto está vacio", Toast.LENGTH_LONG).show()
                              Concepto.requestFocus()
                              return@FloatingActionButton
                          }
                          if (PrestamoViewModel.monto.toFloat() <= 0) {
                              Toast.makeText(context, "El Monto debe ser mayor que cero!", Toast.LENGTH_LONG)
                                  .show()
                              Monto.requestFocus()
                              return@FloatingActionButton
                          }
                          PrestamoViewModel.Guardar()
                    navHostController.navigate("RegistroPrestamo")
                },
                backgroundColor = MaterialTheme.colors.background
            ){
                Icon(imageVector = Icons.TwoTone.Save, contentDescription = "Save")}
},
    ) {
        it

        Column(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = PrestamoViewModel.fecha,
                onValueChange = { PrestamoViewModel.fecha = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Fecha")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
                }
            )

            OutlinedTextField(
                value = PrestamoViewModel.concepto,
                onValueChange = { PrestamoViewModel.concepto = it },
                modifier = Modifier.fillMaxWidth()
                    .focusRequester(Concepto),
                label = {
                    Text(text = "Concepto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.InsertComment,
                        contentDescription = null
                    )
                }
            )

            OutlinedTextField(
                value = PrestamoViewModel.monto,
                onValueChange = { PrestamoViewModel.monto = it },
                modifier = Modifier.fillMaxWidth()
                    .focusRequester(Monto),
                label = {
                    Text(text = "Monto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Smartphone,
                        contentDescription = null
                    )
                }
            )

            OutlinedTextField(
                value = PrestamoViewModel.vence,
                onValueChange = { PrestamoViewModel.vence = it },
                modifier = Modifier.fillMaxWidth()
                    .focusRequester(Vence),
                label = {
                    Text(text = "Vence")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
                }
            )

        }
    }
}

