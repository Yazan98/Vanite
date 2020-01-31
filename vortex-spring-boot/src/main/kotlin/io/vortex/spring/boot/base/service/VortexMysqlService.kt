package io.vortex.spring.boot.base.service

import io.vortex.spring.boot.base.errors.EmptyErrorDetails
import io.vortex.spring.boot.base.errors.VortexInternalServerException
import io.vortex.spring.boot.base.errors.VortexNotFoundException
import io.vortex.spring.boot.base.models.database.VortexMysqlEntity
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional


/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:43 PM
 */

@Service
@Transactional
abstract class VortexMysqlService<ID, Entity : VortexMysqlEntity, Repo : JpaRepository<Entity, ID>> : VortexMysqlServiceImpl<ID, Entity, Repo> {

    @Throws(VortexNotFoundException::class)
    override fun getAllEntities(): ArrayList<Entity> {
        try {
            return if (checkRepoStatus(getRepository())) {
                getRepository().findAll() as ArrayList<Entity>
            } else {
                throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, "No Data Available For This Section"))
            }
        } catch (ex: EmptyResultDataAccessException) {
            throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(null, ex.message))
        }

    }

    @Throws(VortexNotFoundException::class)
    override fun getEntityById(id: ID): Entity {
        try {
            return if (checkRepoStatus(getRepository())) {
                getRepository().findById(id).get()
            } else {
                throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(id, "No Data Available For This Section"))
            }
        } catch (ex: NoSuchElementException) {
            throw VortexNotFoundException(ex.message, EmptyErrorDetails(id, ex.message))
        }
    }

    override fun checkRepoStatus(repo: Repo): Boolean = getRepository().count() > 0

    override fun deleteAllEntities() {
        getRepository().deleteAll()
    }

    @Throws(VortexNotFoundException::class)
    override fun deleteEntityById(id: ID): Boolean {
        return if (checkRepoStatus(getRepository())) {
            getRepository().deleteById(id)
            try {
                getEntityById(id)
                throw VortexInternalServerException("Data Not Deleted", VortexInternalServerException.DataNotDeletedDetails(
                        id,
                        "Data Not Deleted For This ID ... Still in Database"
                ))
            } catch (ex: NoSuchElementException) {
                true
            }
        } else {
            throw VortexNotFoundException("Data Not Found", EmptyErrorDetails(id, "No Data To Delete At This Section"))
        }
    }

}
