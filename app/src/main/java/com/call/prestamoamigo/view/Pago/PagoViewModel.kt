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
    var pagos = pagosRepository.GetLista()
        private set

    var expanded by mutableStateOf(false)
    var selectedPrestamo by mutableStateOf("")
    var selectId by mutableStateOf(0)
    var selectmonto by mutableStateOf(0.00)

    fun Guardar(){
        viewModelScope.launch {
            pagosRepository.Insertar(
                Pago(
                    pagoId = 0,
                    fecha = fecha,
                    prestamoId = selectId.toInt(),
                    concepto = concepto,
                    monto = selectmonto.toFloat()
                )
            )
            pagosRepository.pagarPrestamo(selectId)
        }
    }
}
