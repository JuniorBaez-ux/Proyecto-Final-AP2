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
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosDb {
        val DATABASE_NAME = "PrestamoDb"
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun ProvidePersonaDb(@ApplicationContext context: Context): PersonasDb {
        val DATABASE_NAME = "PersonaDb"
        return Room.databaseBuilder(
            context,
            PersonasDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun ProvidePagoDb(@ApplicationContext context: Context): PagosDb {
        val DATABASE_NAME = "PagoDb"
        return Room.databaseBuilder(
            context,
            PagosDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosDb): PrestamosDao {
        return prestamosDb.prestamosDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamosDao: PrestamosDao): PrestamosRepository {
        return PrestamosRepository(prestamosDao)
    }

    @Provides
    fun ProvidePersonaDAO(personasDb: PersonasDb): PersonasDao {
        return personasDb.personaDao
    }

    @Provides
    fun ProvidePersonaRepository(personasDao: PersonasDao): PersonasRepository {
        return PersonasRepository(personasDao)
    }

    @Provides
    fun ProvidePagoDAO(pagosDb: PagosDb): PagosDao {
        return pagosDb.pagosDao
    }

    @Provides
    fun ProvidePagoRepository(pagosDao: PagosDao): PagosRepository {
        return PagosRepository(pagosDao)
    }
}
