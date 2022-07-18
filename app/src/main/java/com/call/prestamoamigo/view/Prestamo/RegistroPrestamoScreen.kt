package com.call.prestamoamigo.ui.components.prestamo

import android.app.DatePickerDialog
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.ui.theme.backgroundColor
import com.call.prestamoamigo.view.Prestamo.PrestamoViewModel
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS
import javax.xml.validation.Validator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RegistroPrestamoSceen(navHostController: NavHostController,
                          PrestamoViewModel: PrestamoViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val contexto = LocalContext.current

    var erro by rememberSaveable { mutableStateOf(false)}
    val Monto = FocusRequester()
    val Concepto = FocusRequester()
    val Vence = FocusRequester()
    val Fecha = FocusRequester()

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    //Calendario fecha dia Actual
    val date = DatePickerDialog(
        contexto, {d, year, month, day->
            val month = month + 1
            PrestamoViewModel.fecha = "$day / $month / $year"
        },year, month, day
    )
    //Calendario fecha Vencimiento
    val date2 = DatePickerDialog(
        contexto, {d, year, month, day->
            val month = month + 1
            PrestamoViewModel.vence = "$day / $month / $year"
        },year, month, day
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Prestamo") }) },
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
                    readOnly = true,
                    leadingIcon = {
                        IconButton(onClick = { date.show() }) {
                            Icon(
                                imageVector = Icons.Default.CalendarToday,
                                contentDescription = null
                            )
                        }
                    }
                )

                OutlinedTextField(
                    value = PrestamoViewModel.concepto,
                    onValueChange = { PrestamoViewModel.concepto = it },
                    modifier = Modifier
                        .fillMaxWidth()
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(Monto),
                        label = {
                            Text(text = "Monto")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Money,
                                contentDescription = null
                            ) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                    )

            OutlinedTextField(
                        value = PrestamoViewModel.vence,
                        onValueChange = { PrestamoViewModel.vence = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Fecha Vencimiento")
                        },
                        readOnly = true,
                        leadingIcon = {
                            IconButton(onClick = { date2.show() }) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = null
                                )
                            }
                        }
                    )
            OutlinedButton(
                onClick = {
                    //if (validateFecha(PrestamoViewModel.concepto) || validateFecha(PrestamoViewModel.fecha)) {
                       // if(validateNum(PrestamoViewModel.monto)){
                            PrestamoViewModel.Guardar()
                            navHostController.navigate("ConsultaPrestamo")
                        //}

                    /*if (PrestamoViewModel.vence.isNullOrEmpty()) {

                        Toast.makeText(context, "La fecha Vence está vacio!", Toast.LENGTH_LONG).show()
                        Vence.requestFocus()
                        return@OutlinedButton
                    }*/
                   // if (PrestamoViewModel.concepto.isNullOrEmpty()) {
                    //    Toast.makeText(context, "El campo Concepto está vacio", Toast.LENGTH_LONG).show()
                      //  Concepto.requestFocus()
                        //return@OutlinedButton
                    //}
                    /*if (PrestamoViewModel.monto.toFloat() <= 0) {
                        Toast.makeText(context, "El Monto debe ser mayor que cero!", Toast.LENGTH_LONG)
                            .show()
                        Monto.requestFocus()
                        return@OutlinedButton*/
                    //}else{
                    //    Toast.makeText(context, "Ingrese informacion Valida", Toast.LENGTH_SHORT).show() }
        },
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(6.dp)
            ) {
                Text("Guardar ")
            }
        }
    }
}
/*
fun validateFecha(cadena: String): Boolean {

    val validate = String.toString()
    if(validate.isNullOrEmpty()){
        return true
    }
    else{
        return false
    }
}
fun validateNum(num: String): Boolean {

    val valida = Double
    if(valida.POSITIVE_INFINITY > 0 && valida.MIN_VALUE > 0){
        return true
    }
    else{
        return false
    }
}
*/



