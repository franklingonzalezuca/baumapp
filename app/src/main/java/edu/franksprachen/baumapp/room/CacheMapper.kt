package edu.franksprachen.baumapp.room

import edu.franksprachen.baumapp.model.Tree
import edu.franksprachen.baumapp.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<Tree,TreeCacheEntity>{
    override fun mapFromEntity(entity: Tree): TreeCacheEntity {
        return TreeCacheEntity(
            key = entity.key,
            name = entity.name,
            scientificName = entity.scientificName,
            description = entity.description,
            picture = entity.picture
        )
    }

    override fun mapToEntity(domainModel: TreeCacheEntity): Tree {
        return Tree(
            key = domainModel.key,
            name = domainModel.name,
            scientificName = domainModel.scientificName,
            description = domainModel.description,
            picture = domainModel.picture
        )
    }

    fun mapFromListEntity(entities:List<TreeCacheEntity>): List<Tree> {
        return entities.map { mapToEntity(it) }
    }
}