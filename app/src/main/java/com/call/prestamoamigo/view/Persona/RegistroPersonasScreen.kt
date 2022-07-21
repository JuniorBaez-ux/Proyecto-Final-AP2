package com.example.p1_ap2_junior_20190009.ui.Prestamo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.call.prestamoamigo.view.Persona.PersonaViewModel

@Composable
fun RegistroPersonasScreen(
    navHostController: NavHostController,
    personaViewModel: PersonaViewModel = hiltViewModel()
    ) {

    var error by rememberSaveable{ mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Personas") }) }
    ){it


    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = personaViewModel.nombre,
            onValueChange = {personaViewModel.nombre = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null)
            }
        )

        OutlinedTextField(
            value = personaViewModel.telefono,
            onValueChange = {personaViewModel.telefono = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Telefono")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Smartphone,
                    contentDescription = null)
            }
        )

        OutlinedTextField(
            value = personaViewModel.correo,
            onValueChange = {personaViewModel.correo = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = null)
            }
        )
        OutlinedTextField(
            value = personaViewModel.direccion,
            onValueChange = {personaViewModel.direccion = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Direccion")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null)
            }
        )

        OutlinedButton(
            onClick = {
                if (!validateNameAndDirection(personaViewModel.nombre)){
                    Toast.makeText(context, "Por favor revise el campo Nombre", Toast.LENGTH_SHORT).show()
                }
                else if (!validateTelephone(personaViewModel.telefono)){
                    Toast.makeText(context, "Revise el formato del campo Telefono", Toast.LENGTH_SHORT).show()
                }
                else if (!validateEmail(personaViewModel.correo)){
                    Toast.makeText(context, "Revise el formato del campo Email", Toast.LENGTH_SHORT).show()
                }
                else if (!validateNameAndDirection(personaViewModel.direccion)){
                    Toast.makeText(context, "Por favor revise el campo Direccion", Toast.LENGTH_SHORT).show()
                }
                if (validateNameAndDirection(personaViewModel.nombre) && validateNameAndDirection(personaViewModel.direccion) && validateEmail(personaViewModel.correo) &&validateTelephone(personaViewModel.telefono)){
                    personaViewModel.Guardar()
                    navHostController.navigate("ConsultaPersonas")
                }
            }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = "Guardar", color = Color.Black)
        }
    }
    }
}

fun validateNameAndDirection(evaluacion: String) : Boolean{
    return evaluacion.isNotEmpty() && evaluacion.length > 2
}

fun validateEmail(correo: String) : Boolean{
    var patron =  "([a-z0-9]+@[a-z]+\\.[a-z]{2,3})".toRegex()
    return patron.containsMatchIn(correo)
}

fun validateTelephone(telefono: String) : Boolean{
    var patron =  "(^[0-9]{3}-[0-9]{3}-[0-9]{4})".toRegex()
    return patron.containsMatchIn(telefono)
}
