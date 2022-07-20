package com.call.prestamoamigo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombre: String,
    val telefono: String,
    val correo: String,
    val direccion: String,
    val prestamosTotales: Int
)