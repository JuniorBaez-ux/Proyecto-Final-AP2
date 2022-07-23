package com.call.prestamoamigo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.prestamoamigo.data.PrestamosDao
import com.call.prestamoamigo.model.Pago
import com.call.prestamoamigo.model.Persona
import com.call.prestamoamigo.model.Prestamo

@Database(
    entities = [Prestamo::class, Persona::class, Pago::class],
    version = 3
)
abstract class PrestamosAmigosDb: RoomDatabase() {
    abstract  val prestamosDao: PrestamosDao
    abstract  val personaDao: PersonasDao
    abstract  val pagosDao: PagosDao
}