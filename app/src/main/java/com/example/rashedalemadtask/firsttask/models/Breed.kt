package com.example.rashedalemadtask.firsttask.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed")
class Breed {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id :Int=0

    @ColumnInfo(name = "imageUrl")
    var imageUrl :String=""

    @ColumnInfo(name = "breedname")
    var breedname :String=""
}