package com.example.rashedalemadtask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rashedalemadtask.database.dao.BreedDao
import com.example.rashedalemadtask.firsttask.models.Breed

@Database(entities = [Breed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedsDao(): BreedDao

}