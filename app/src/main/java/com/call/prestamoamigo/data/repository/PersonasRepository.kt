package com.call.prestamoamigo.data.repository

import com.call.prestamoamigo.data.PersonasDao
import com.call.prestamoamigo.model.Personas
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PersonasRepository @Inject constructor(
    val personasDao: PersonasDao
) {
    suspend fun Insertar(personas: Personas)= personasDao.Insertar(personas)

    fun Buscar(personas: Int): Flow<Personas>   =  personasDao.Buscar(personas)

    suspend fun Eliminar(personas: Personas)= personasDao.Eliminar(personas)

    fun GetLista(): Flow<List<Personas>> = personasDao.GetLista()
}
