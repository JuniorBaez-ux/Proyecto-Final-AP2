package com.call.prestamoamigo.model

import androidx.room.Entity

@Entity(tableName = "Pagos")
data class Pago(
    val pagoId: Int,
    val fecha: String,
    val prestamoId: Int,
    val concepto: String,
    val monto: Float
)