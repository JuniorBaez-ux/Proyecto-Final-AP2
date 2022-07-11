package com.call.prestamoamigo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Personas(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int,
    val nombre: String,
    val telefono: String,
    val correo: String,
    val direccion: String
)