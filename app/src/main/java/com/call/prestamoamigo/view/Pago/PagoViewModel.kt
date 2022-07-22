package com.call.prestamoamigo.view.Pago

import android.content.ClipData
import androidx.compose.material.ListItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.prestamoamigo.data.repository.PagosRepository
import com.call.prestamoamigo.data.repository.PrestamosRepository
import com.call.prestamoamigo.model.Pago
import com.call.prestamoamigo.model.Persona
import com.call.prestamoamigo.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PagoViewModel @Inject constructor(
    val pagosRepository: PagosRepository,
): ViewModel(){
    var fecha by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")

    var pagos = pagosRepository.GetLista()
        private set

    var prestamosPersonas = pagosRepository.listaPrestamos(2)
    private set

    val options = listOf("")

    var expanded by mutableStateOf(false)
    var selectedPrestamo by mutableStateOf(options[0])
    var selectId by mutableStateOf(0)

    fun Guardar(){
        viewModelScope.launch {
            pagosRepository.Insertar(
                Pago(
                    pagoId = 0,
                    fecha = fecha,
                    prestamoId = selectId.toInt(),
                    concepto = concepto,
                    monto = monto.toFloat()
                )
            )
        }
    }


}
