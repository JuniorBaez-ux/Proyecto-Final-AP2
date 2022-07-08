package com.call.prestamoamigo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.prestamoamigo.model.Persona

@Database(
    entities = [Persona::class],
    version = 1
)
abstract class PersonasDb: RoomDatabase() {
    abstract  val personaDao: PersonasDao

}
