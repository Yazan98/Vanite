package io.vortex.spring.boot.base.models.database

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import javax.persistence.Column

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:36 PM
 */

open class VortexMysqlEntity<ID>(
        @Column(name = "created_by") @CreatedBy override var createdBy: ID,
        @Column(name = "created_date") @CreatedDate override var createdDate: Instant = Instant.now()
) : VortexBaseEntity<ID>(createdBy = createdBy, createdDate = createdDate)
