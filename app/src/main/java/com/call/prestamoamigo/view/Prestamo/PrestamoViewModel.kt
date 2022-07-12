package com.call.prestamoamigo.view.Prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.prestamoamigo.data.repository.PrestamosRepository
import com.call.prestamoamigo.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamosRepository: PrestamosRepository
): ViewModel(){

    var fecha by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")
    var vence by mutableStateOf("")

    var prestamos = prestamosRepository.GetLista()
        private set

    fun Guardar(){
        viewModelScope.launch {
            prestamosRepository.Insertar(
                Prestamo(
                    prestamoId = 0,
                    fecha = fecha,
                    personaId = 0,
                    concepto = concepto,
                    monto = monto.toFloat(),
                    vence = vence
                )
            )
        }
    }
}