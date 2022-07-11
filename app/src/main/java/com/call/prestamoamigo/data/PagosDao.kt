package com.call.prestamoamigo.data

import androidx.room.*
import com.call.prestamoamigo.model.Pago
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

}
