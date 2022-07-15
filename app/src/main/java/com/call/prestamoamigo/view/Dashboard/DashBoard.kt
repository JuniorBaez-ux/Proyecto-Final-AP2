package com.call.prestamoamigo.view.Dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DashBoard (navHostController: NavHostController){
    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Dashboard") })
        },

        scaffoldState = ScaffoldState
    ) {it
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

                    ){

            }
            Button(onClick = {  },
                modifier = Modifier
                .fillMaxWidth()) {
               Text(text = "Pretamo")
            }
            Button(onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text(text = "Pagar")
            }
        }
    }
}
