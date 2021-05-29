package edu.franksprachen.baumapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import edu.franksprachen.baumapp.room.TreeDao
import edu.franksprachen.baumapp.room.TreeDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideCatDb(@ApplicationContext context: Context):TreeDatabase {
        return Room
            .databaseBuilder(context, TreeDatabase::class.java, TreeDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCatDao(catDatabase: TreeDatabase):TreeDao {
        return catDatabase.treeDao()
    }
}