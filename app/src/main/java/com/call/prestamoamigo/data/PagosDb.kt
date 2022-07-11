package com.call.prestamoamigo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.prestamoamigo.model.Pago

@Database(
    entities = [Pago::class],
    version = 1
)
abstract class PagosDb: RoomDatabase() {
    abstract  val pagosDao: PagosDao

}
