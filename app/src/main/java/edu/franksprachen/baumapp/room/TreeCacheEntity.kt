package edu.franksprachen.baumapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tree")
class TreeCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "key")
    var key:String,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "scientificName")
    var scientificName:String,

    @ColumnInfo(name = "description")
    var description:String,

    @ColumnInfo(name = "picture")
    var picture:String
)