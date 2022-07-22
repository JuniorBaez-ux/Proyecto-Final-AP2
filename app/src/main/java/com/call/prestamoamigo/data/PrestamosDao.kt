package com.call.prestamoamigo.data

import androidx.room.*
import com.call.prestamoamigo.model.Prestamo
import kotlinx.coroutines.flow.Flow


@Dao
interface PrestamosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(prestamo: Prestamo)

    @Delete
    suspend fun Eliminar(prestamo: Prestamo)


    @Query(
        """
        SELECT * 
        FROM Prestamos
        WHERE prestamoId=:prestamoId        
    """
    )
    fun Buscar(prestamoId: Int): Flow<Prestamo>

    @Query(
        """
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """
    )
    fun GetLista(): Flow<List<Prestamo>>

    @Query(
        """
        UPDATE Personas
        SET prestamosTotales = prestamosTotales + 1
        WHERE personaId =:personaId  
    """
    )
    suspend fun aumentoPrestamosTotales(personaId: Int?)

}
