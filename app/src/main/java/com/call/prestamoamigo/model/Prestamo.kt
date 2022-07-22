package com.call.prestamoamigo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int,
    val concepto: String,
    val fecha: String,
    val vence: String,
    val monto: Double ,
    val activo: Int,
    val personaId: Int,

)