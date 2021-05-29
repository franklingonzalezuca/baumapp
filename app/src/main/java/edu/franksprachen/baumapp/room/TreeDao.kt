package edu.franksprachen.baumapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrees(treeCacheEntity:TreeCacheEntity):Long

    @Query("SELECT * FROM Tree")
    suspend fun getTrees():List<TreeCacheEntity>
}