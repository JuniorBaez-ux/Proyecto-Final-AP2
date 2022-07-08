package com.call.prestamoamigo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.prestamoamigo.data.PrestamosDao
import com.call.prestamoamigo.model.Prestamo

@Database(
    entities = [Prestamo::class],
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract  val prestamosDao: PrestamosDao

}
