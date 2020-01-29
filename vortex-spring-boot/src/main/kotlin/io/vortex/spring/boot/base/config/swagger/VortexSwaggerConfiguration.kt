package io.vortex.spring.boot.base.config.swagger

import io.vortex.spring.boot.base.config.impl.SwaggerConfiguration
import io.vortex.spring.boot.base.models.VortexSwaggerDetails
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


/**
 * Created By : Yazan Tarifi
 * Date : 10/28/2019
 * Time : 2:34 AM
 */

abstract class VortexSwaggerConfiguration : SwaggerConfiguration<VortexSwaggerDetails> {

    @Bean
    override fun getSwaggerConfiguration(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo = ApiInfoBuilder()
            .description(getSwaggerDetails().description)
            .license(getSwaggerDetails().license)
            .contact(Contact(getSwaggerDetails().contact.name, getSwaggerDetails().contact.website, getSwaggerDetails().contact.email))
            .licenseUrl(getSwaggerDetails().licenseUrl)
            .title(getSwaggerDetails().title)
            .build()

}
