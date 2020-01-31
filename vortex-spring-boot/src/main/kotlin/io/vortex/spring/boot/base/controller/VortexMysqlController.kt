package io.vortex.spring.boot.base.controller

import io.vortex.spring.boot.base.errors.VortexInvalidValueException
import io.vortex.spring.boot.base.errors.details.BodyErrorDetails
import io.vortex.spring.boot.base.models.database.VortexMysqlEntity
import io.vortex.spring.boot.base.response.VortexListResponse
import io.vortex.spring.boot.base.response.VortexResponse
import io.vortex.spring.boot.base.response.VortexSuccessResponse
import io.vortex.spring.boot.base.service.VortexMysqlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:15 PM
 */

@Component
open class VortexMysqlController<E : VortexMysqlEntity, ID, R : JpaRepository<E, ID>, S : VortexMysqlService<ID, E, R>> @Autowired constructor(
        private val controller: S
) : VortexMysqlControllerImpl<E, ID, R, S> {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], value = [""])
    override fun save(@Valid @RequestBody content: E?): ResponseEntity<VortexResponse> {
        if (content == null) {
            throw VortexInvalidValueException("Body Required", BodyErrorDetails(
                    "Body Not Attached",
                    "Create Request"
            ))
        } else {
            val result = getService().create(content)
            return ResponseEntity.status(HttpStatus.CREATED).body(VortexSuccessResponse(
                    code = HttpStatus.CREATED.value(),
                    message = "Data Saved",
                    data = result
            ))
        }
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.PUT], value = [""])
    override fun update(@Valid @RequestBody content: E?): ResponseEntity<VortexResponse> {
        if (content == null) {
            throw VortexInvalidValueException("Body Required", BodyErrorDetails(
                    "Body Not Attached",
                    "Update Request"
            ))
        } else {
            val result = getService().update(content)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(VortexSuccessResponse(
                    code = HttpStatus.ACCEPTED.value(),
                    message = "Data Updated",
                    data = result
            ))
        }
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.DELETE], value = ["/{id}"])
    override fun deleteById(@PathVariable("id") id: ID?): ResponseEntity<VortexResponse> {
        if (id == null) {
            throw VortexInvalidValueException("Id Required", BodyErrorDetails(
                    "Id Attached",
                    "Delete Request"
            ))
        } else {
            val result = getService().deleteEntityById(id)
            return ResponseEntity.status(HttpStatus.OK.value()).body(VortexSuccessResponse(
                    code = HttpStatus.OK.value(),
                    message = "Data Deleted",
                    data = result
            ))
        }
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.DELETE], value = ["/all"])
    override fun deleteAll(): ResponseEntity<VortexResponse> {
        getService().deleteAllEntities()
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(VortexSuccessResponse(
                code = HttpStatus.NOT_FOUND.value(),
                status = "Success",
                message = "Data Deleted",
                data = null
        ))
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/{id}"])
    override fun getById(@PathVariable("id") id: ID?): ResponseEntity<VortexResponse> {
        if (id == null) {
            throw VortexInvalidValueException("Id Required", BodyErrorDetails(
                    "Id Attached",
                    "Get By Id Request"
            ))
        } else {
            val result = getService().getEntityById(id)
            return ResponseEntity.status(HttpStatus.OK.value()).body(VortexSuccessResponse(
                    code = HttpStatus.OK.value(),
                    message = "Data Found",
                    data = result
            ))
        }
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/all"])
    override fun getAll(): ResponseEntity<VortexResponse> {
        val result = getService().getAllEntities()
        return ResponseEntity.status(HttpStatus.OK).body(VortexListResponse(
                code = HttpStatus.OK.value(),
                data = result,
                message = "Data Found",
                status = "Success",
                size = result.size
        ))
    }

    override fun getService(): S {
        return controller
    }

}
