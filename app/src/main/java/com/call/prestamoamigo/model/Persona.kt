package com.call.prestamoamigo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val telefono: String,
    val email: String,
    val direccion: String
)