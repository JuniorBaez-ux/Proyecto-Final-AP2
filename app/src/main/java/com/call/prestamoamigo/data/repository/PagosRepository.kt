package com.call.prestamoamigo.data.repository

import com.call.prestamoamigo.data.PagosDao
import com.call.prestamoamigo.data.PersonasDao
import com.call.prestamoamigo.data.PrestamosDao
import com.call.prestamoamigo.model.Pago
import com.call.prestamoamigo.model.Persona
import com.call.prestamoamigo.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PagosRepository @Inject constructor(
    val pagosDao: PagosDao
) {
    suspend fun Insertar(pagos: Pago)= pagosDao.Insertar(pagos)

    fun Buscar(pagos: Int): Flow<Pago>   =  pagosDao.Buscar(pagos)

    suspend fun Eliminar(pagos: Pago)= pagosDao.Eliminar(pagos)

    fun GetLista(): Flow<List<Pago>> = pagosDao.GetLista()
}
