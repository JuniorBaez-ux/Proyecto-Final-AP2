package com.call.prestamoamigo.data

import androidx.room.*
import com.call.prestamoamigo.model.Pago
import com.call.prestamoamigo.model.Prestamo
import kotlinx.coroutines.flow.Flow


@Dao
interface PagosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(pago: Pago)

    @Delete
    suspend fun Eliminar(pago: Pago)


    @Query(
        """
        SELECT * 
        FROM Pagos
        WHERE pagoId=:pagoId        
    """
    )
    fun Buscar(pagoId: Int): Flow<Pago>

    @Query(
        """
        SELECT * 
        FROM Pagos
        ORDER BY pagoId    
    """
    )
    fun GetLista(): Flow<List<Pago>>

    @Query("SELECT *FROM Prestamos WHERE personaId=:personaId AND activo = 0 ORDER BY prestamoId")
    fun listaPrestamos(personaId: Int): Flow<List<Prestamo>>

    @Query("UPDATE Prestamos SET activo = 1 WHERE prestamoId=:prestamoId")
    suspend fun pagarPrestamo(prestamoId: Int)

    @Query("UPDATE Personas SET prestamosTotales = prestamosTotales - 1")
    suspend fun disminuirPrestamo(personaId:Int)

}
