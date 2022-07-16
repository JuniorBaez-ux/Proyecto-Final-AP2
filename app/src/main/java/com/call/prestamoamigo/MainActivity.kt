package com.call.prestamoamigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.call.prestamoamigo.ui.components.prestamo.RegistroPrestamoSceen
import com.call.prestamoamigo.ui.theme.PrestamoAmigoTheme
import com.call.prestamoamigo.view.Dashboard.DashBoard
import com.call.prestamoamigo.view.Pago.ConsultaPagoScreen
import com.call.prestamoamigo.view.Pago.RegistroPagoScreen
import com.call.prestamoamigo.view.Persona.ConsultaPersonasScreen
import com.call.prestamoamigo.view.Prestamo.ConsultaPrestamoScreen
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

    NavHost(navController = navHostController, startDestination = "Consultapago"){
        composable("ConsultaPersonas"){
            ConsultaPersonasScreen(navHostController = navHostController)
        }
        composable("RegistroPersonas"){
            RegistroPersonasScreen(navHostController = navHostController)
        }
        composable("DashBoard"){
            DashBoard(navHostController = navHostController)
        }
        composable("RegistroPrestamo"){
            RegistroPrestamoSceen(navHostController = navHostController)
        }
        composable("ConsultaPrestamo"){
            ConsultaPrestamoScreen(navHostController = navHostController)
        }
        composable("Consultapago"){
            ConsultaPagoScreen(navHostController = navHostController)
        }
        composable("Registropago"){
            RegistroPagoScreen(navHostController = navHostController)
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