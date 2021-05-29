package edu.franksprachen.baumapp.repository

import edu.franksprachen.baumapp.retrofit.TreeNetworkMapper
import edu.franksprachen.baumapp.retrofit.TreeRetrofit
import edu.franksprachen.baumapp.room.CacheMapper
import edu.franksprachen.baumapp.room.TreeDao
import edu.franksprachen.baumapp.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class TreeRepository constructor(
    private val treeDao: TreeDao,
    private val treeRetrofit: TreeRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: TreeNetworkMapper
) {
    suspend fun getTrees(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(2000)
        try {
            val catData = treeRetrofit.getTrees()
            val catMap = networkMapper.mapFromListEntities(catData)
            for(tempCat in catMap) {
                treeDao.insertTrees(cacheMapper.mapFromEntity(tempCat))
            }
            val cacheCat = treeDao.getTrees()
            emit(DataState.Success(cacheMapper.mapFromListEntity(cacheCat)))
        }
        catch (e: Exception) {
            //  emit(DataState.Error(e))
            val cacheCat = treeDao.getTrees()
            //EMIT: Es un notificador de que una accion se ha completado o ha dado un error.
            // El medio de transporte es DataState.
            emit(DataState.Success(cacheMapper.mapFromListEntity(cacheCat)))
        }
    }
}