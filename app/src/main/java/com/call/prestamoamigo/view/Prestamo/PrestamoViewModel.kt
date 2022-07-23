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
    val prestamosRepository: PrestamosRepository,

): ViewModel(){

    var fecha by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")
    var vence by mutableStateOf("")
    var activo by mutableStateOf(0)
    var personaIdentification by mutableStateOf(0)


    var prestamos = prestamosRepository.GetLista()
        private set
    var expanded by mutableStateOf(false)

    fun Guardar(){
        viewModelScope.launch {
            prestamosRepository.Insertar(
                Prestamo(
                    prestamoId = 0,
                    fecha = fecha,
                    personaId = personaIdentification.toInt(),
                    concepto = concepto,
                    monto = monto.toString().toDouble(),
                    vence = vence,
                    activo = 0,
                 )
            )

            prestamosRepository.aumentoPrestamosTotales(personaIdentification)
        }
    }
}