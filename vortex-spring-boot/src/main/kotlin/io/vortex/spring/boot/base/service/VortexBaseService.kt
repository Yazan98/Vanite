package io.vortex.spring.boot.base.service

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:34 PM
 */

interface VortexBaseService<ID, Entity : VortexMysqlEntity, Repo> {

    fun create(entity: Entity): Entity

    fun update(entity: Entity): Entity

    fun getEntityById(id: ID): Entity

    fun getAllEntities(): ArrayList<Entity>

    fun deleteEntityById(id: ID): Boolean

    fun deleteAllEntities()

    fun getRepository(): Repo

    fun checkRepoStatus(repo: Repo = getRepository()): Boolean

}

interface VortexMysqlServiceImpl<ID, Entity : VortexMysqlEntity, Repo : JpaRepository<Entity, ID>>: VortexBaseService<ID , Entity , Repo>

