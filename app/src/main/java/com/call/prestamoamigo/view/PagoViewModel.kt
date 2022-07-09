package com.call.prestamoamigo.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.prestamoamigo.data.repository.PagosRepository
import com.call.prestamoamigo.model.Pago
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PagoViewModel @Inject constructor(
    val pagosRepository: PagosRepository
): ViewModel(){
    var fecha by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")

    var pagos = pagosRepository.GetLista()
        private set

    fun Guardar(){
        viewModelScope.launch {
            pagosRepository.Insertar(
                Pago(
                    pagoId = 0,
                    fecha = fecha,
                    prestamoId = 0,
                    concepto = concepto,
                    monto = monto.toFloat()
                )
            )
        }
    }


}