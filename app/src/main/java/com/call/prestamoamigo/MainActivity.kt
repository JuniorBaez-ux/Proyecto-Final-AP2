package com.call.prestamoamigo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.call.prestamoamigo.ui.components.prestamo.RegistroPrestamoSceen
import com.call.prestamoamigo.ui.theme.PrestamoAmigoTheme
import com.call.prestamoamigo.view.Dashboard.DashBoard
import com.call.prestamoamigo.view.Pago.ConsultaPagoScreen
import com.call.prestamoamigo.view.Pago.RegistroPagoScreen
import com.call.prestamoamigo.view.Persona.ConsultaPersonasScreen
import com.call.prestamoamigo.view.Prestamo.ConsultaPrestamoScreen
import com.call.prestamoamigo.view.Prestamo.PrestamoViewModel
import com.example.p1_ap2_junior_20190009.ui.Prestamo.RegistroPersonasScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamoAmigoTheme {
                MyApp()
                }
            }
        }
    }


@Preview
@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "ConsultaPersonas"){
        composable("ConsultaPersonas"){
            ConsultaPersonasScreen(navHostController = navHostController)
        }
        composable("RegistroPersonas"){
            RegistroPersonasScreen(navHostController = navHostController)
        }
        composable("DashBoard/{id}/{nombre}/{telefono}/{correo}/{direccion}/{prestamosTotales}",
            arguments = listOf(navArgument(name = "id"){
                    type = NavType.IntType
            },
            navArgument(name = "nombre"){
                type = NavType.StringType
            },
            navArgument(name = "telefono"){
                type = NavType.StringType
            },
            navArgument(name = "correo"){
                type = NavType.StringType
            },
            navArgument(name = "direccion"){
                type = NavType.StringType
            },
            navArgument(name = "prestamosTotales"){
                type = NavType.IntType
            }
            )){
            val personaIdentification = it.arguments?.getInt("id").toString()
            val prestamosTotalesDelCliente = it.arguments?.getInt("prestamosTotales").toString()
            val nombrePersona = it.arguments?.getString("nombre").toString()
            val telefonoPersona = it.arguments?.getString("telefono").toString()
            val correoPersona = it.arguments?.getString("correo").toString()
            val direccionPersona = it.arguments?.getString("direccion").toString()
            Log.d("Id de la persona", it.arguments?.getInt("id").toString())
            Log.d("Nombre de la persona", it.arguments?.getString("nombre").toString())
            Log.d("Correo de la persona", it.arguments?.getString("correo").toString())
            Log.d("Telefono de la persona", it.arguments?.getString("telefono").toString())
            Log.d("Direccion de la persona", it.arguments?.getString("direccion").toString())
            Log.d("Prestamos totales de la persona", it.arguments?.getInt("id").toString())
            DashBoard(navHostController = navHostController, personaIdentification.toInt(),  prestamosTotalesDelCliente.toInt(), nombrePersona, telefonoPersona, correoPersona, direccionPersona)

        }
        composable("RegistroPrestamo/{id}",
            arguments = listOf(navArgument(name = "id"){
                type = NavType.IntType
            })){
            val personaIdentification = it.arguments?.getInt("id").toString()
            Log.d("Args", it.arguments?.getInt("id").toString())
            RegistroPrestamoSceen(navHostController = navHostController, hiltViewModel(), personaIdentification.toInt())
        }
        composable("ConsultaPrestamo/{id}",
            arguments = listOf(navArgument(name = "id"){
                type = NavType.IntType
            },

            )){
            val personaIdentification = it.arguments?.getInt("id").toString()
            Log.d("Args", it.arguments?.getInt("id").toString())
            Log.d("Prestamos totales de la persona", it.arguments?.getInt("id").toString())
            ConsultaPrestamoScreen(navHostController = navHostController, hiltViewModel(), personaIdentification.toInt())
        }
        composable("ConsultaPago/{id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                }
            )){
            val personaIdentification = it.arguments?.getInt("id").toString()
            Log.d("ID de la persona", it.arguments?.getInt("id").toString())
            ConsultaPagoScreen(navHostController = navHostController, hiltViewModel(), personaIdentification.toInt())
        }
        composable("Registropago/{id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                }
            )
            ){
            val personaIdentification = it.arguments?.getInt("id").toString()
            Log.d("ID de la persona", it.arguments?.getInt("id").toString())
            RegistroPagoScreen(navHostController = navHostController, hiltViewModel(), personaIdentification.toInt())
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PrestamoAmigoTheme {
        MyApp()
    }
}