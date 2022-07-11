package com.call.prestamoamigo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.prestamoamigo.model.Personas

@Database(
    entities = [Personas::class],
    version = 1
)
abstract class PersonasDb: RoomDatabase() {
    abstract  val personaDao: PersonasDao

}
