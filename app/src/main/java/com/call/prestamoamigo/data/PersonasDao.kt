package com.call.prestamoamigo.data

import androidx.room.*
import com.call.prestamoamigo.model.Personas
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Personas)

    @Delete
    suspend fun Eliminar(persona: Personas)


    @Query(
        """
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId        
    """
    )
    fun Buscar(personaId: Int): Flow<Personas>

    @Query(
        """
        SELECT * 
        FROM Prestamos
        ORDER BY prestamoId    
    """
    )
    fun GetLista(): Flow<List<Personas>>

}
