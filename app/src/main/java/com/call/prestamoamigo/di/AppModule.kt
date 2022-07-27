package com.call.prestamoamigo.di

import android.content.Context
import androidx.room.Room
import com.call.prestamoamigo.data.*
import com.call.prestamoamigo.data.repository.PagosRepository
import com.call.prestamoamigo.data.repository.PersonasRepository
import com.call.prestamoamigo.data.repository.PrestamosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  AppModule {


    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosAmigosDb {
        val DATABASE_NAME = "PrestamoDb"
        return Room.databaseBuilder(
            context,
            PrestamosAmigosDb::class.java,
            DATABASE_NAME       ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    }


    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosAmigosDb): PrestamosDao {
        return prestamosDb.prestamosDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamosDao: PrestamosDao): PrestamosRepository {
        return PrestamosRepository(prestamosDao)
    }

    @Provides
    fun ProvidePersonaDAO(personasDb: PrestamosAmigosDb): PersonasDao {
        return personasDb.personaDao
    }

    @Provides
    fun ProvidePersonaRepository(personasDao: PersonasDao): PersonasRepository {
        return PersonasRepository(personasDao)
    }

    @Provides
    fun ProvidePagoDAO(pagosDb: PrestamosAmigosDb): PagosDao {
        return pagosDb.pagosDao
    }

    @Provides
    fun ProvidePagoRepository(pagosDao: PagosDao): PagosRepository {
        return PagosRepository(pagosDao)
    }
}
