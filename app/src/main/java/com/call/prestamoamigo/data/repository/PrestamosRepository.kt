package com.call.prestamoamigo.data.repository

import com.call.prestamoamigo.data.PrestamosDao
import com.call.prestamoamigo.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PrestamosRepository @Inject constructor(
    val prestamosDao: PrestamosDao
) {
    suspend fun Insertar(prestamos: Prestamo)= prestamosDao.Insertar(prestamos)

    fun Buscar(prestamos: Int): Flow<Prestamo>   =  prestamosDao.Buscar(prestamos)

    suspend fun Eliminar(prestamos: Prestamo)= prestamosDao.Eliminar(prestamos)

    fun GetLista(): Flow<List<Prestamo>> = prestamosDao.GetLista()
}
