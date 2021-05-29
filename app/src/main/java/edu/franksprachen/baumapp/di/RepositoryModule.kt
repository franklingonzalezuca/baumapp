package edu.franksprachen.baumapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.franksprachen.baumapp.repository.TreeRepository
import edu.franksprachen.baumapp.retrofit.TreeNetworkMapper
import edu.franksprachen.baumapp.retrofit.TreeRetrofit
import edu.franksprachen.baumapp.room.CacheMapper
import edu.franksprachen.baumapp.room.TreeDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCatRepository(
        treeDao: TreeDao,
        treeRetrofit: TreeRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: TreeNetworkMapper
    ): TreeRepository {
        return TreeRepository(treeDao, treeRetrofit, cacheMapper, networkMapper)
    }
}