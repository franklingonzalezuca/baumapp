package edu.franksprachen.baumapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TreeCacheEntity::class], version = 2  )
abstract class TreeDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "BaumApp"
    }
    abstract fun treeDao():TreeDao
}