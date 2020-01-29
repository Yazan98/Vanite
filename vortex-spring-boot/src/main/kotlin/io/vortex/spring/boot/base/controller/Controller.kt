package io.vortex.spring.boot.base.controller

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.service.VortexMysqlService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:10 PM
 */
interface Controller<E , ID , S> {

    fun save(content: E?): ResponseEntity<VortexResponse>

    fun update(content: E?): ResponseEntity<VortexResponse>

    fun deleteById(id: ID?): ResponseEntity<VortexResponse>

    fun deleteAll(): ResponseEntity<VortexResponse>

    fun getById(id: ID?): ResponseEntity<VortexResponse>

    fun getAll(): ResponseEntity<VortexResponse>

    fun getService(): S

}

interface VortexMysqlControllerImpl<E: VortexMysqlEntity<ID> , ID , R: JpaRepository<E , ID> , S: VortexMysqlService<ID , E , R>>
    : Controller<E , ID , S>

