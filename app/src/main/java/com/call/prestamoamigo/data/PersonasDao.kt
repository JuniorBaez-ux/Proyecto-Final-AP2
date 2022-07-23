package com.call.prestamoamigo.data

import androidx.room.*
import com.call.prestamoamigo.model.Persona
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)

    @Delete
    suspend fun Eliminar(persona: Persona)


    @Query(
        """
        SELECT * 
        FROM Personas
        WHERE personaId=:personaId        
    """
    )
    fun Buscar(personaId: Int): Flow<Persona>

    @Query(
        """
        SELECT * 
        FROM Personas
        ORDER BY personaId    
    """
    )
    fun GetLista(): Flow<List<Persona>>

    @Query(
        """
        SELECT SUM(monto)
        FROM Prestamos
        WHERE personaId =:personaId
    """
    )
    suspend fun GetMontoFromPrestamos(personaId:Int?): Double

    @Query(
        """
        SELECT fecha FROM Pagos 
        WHERE prestamoId =:prestamoId
        ORDER BY fecha
        DESC LIMIT 1
    """
    )
    suspend fun GetFechas(prestamoId: Int?): String


    //SELECT fecha FROM Pagos ORDER BY fecha DESC LIMIT 1;
    //SELECT fecha FROM Pagos WHERE
}
