package com.call.prestamoamigo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pagos")
data class Pago(
    @PrimaryKey(autoGenerate = true)
    val pagoId: Int,
    val fecha: String,
    val prestamoId: Int,
    val concepto: String,
    val monto: Float
)