package com.example.rashedalemadtask.core.di

import android.content.Context
import androidx.room.Room
import com.example.rashedalemadtask.database.AppDatabase
import com.example.rashedalemadtask.database.dao.BreedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {


        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "rashedtask.db"
            ).build()
        }

        @Provides
        fun provideLogDao(database: AppDatabase): BreedDao {
            return database.breedsDao()
        }
    }
