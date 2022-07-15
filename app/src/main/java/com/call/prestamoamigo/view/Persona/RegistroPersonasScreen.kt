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
                error = personaViewModel.nombre.isBlank() && personaViewModel.telefono.isBlank() && personaViewModel.correo.isBlank() && personaViewModel.direccion.isBlank()
                if (!error){
                    personaViewModel.Guardar()
                    navHostController.navigate("ConsultaPersonas")
                }else{
                    Toast.makeText(context, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                }

            }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = "Guardar", color = Color.Black)
        }
    }
    }
}

/*
fun validateNumber(number:String): Boolean {
    val validation = number.toDouble()

    if (validation >= 0){
        return true
    }else{
        return false
    }
}*/
