package io.vortex.spring.boot.base.models.database

import java.time.Instant

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:35 PM
 */

open class VortexBaseEntity<ID>(
        open var createdDate: Instant = Instant.now(),
        open var createdBy: ID
)
