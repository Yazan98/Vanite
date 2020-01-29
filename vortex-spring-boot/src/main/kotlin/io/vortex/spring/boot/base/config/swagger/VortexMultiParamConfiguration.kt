package io.vortex.spring.boot.base.config.swagger

import io.vortex.spring.boot.base.config.impl.SwaggerConfiguration
import io.vortex.spring.boot.base.models.VortexSwaggerDetails
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

/**
 * Created By : Yazan Tarifi
 * Date : 10/28/2019
 * Time : 2:35 AM
 */

abstract class VortexMultiParamConfiguration : SwaggerConfiguration.SwaggerMultiParamConfiguration<VortexSwaggerDetails> {

    @Bean
    override fun getSwaggerConfiguration(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getSwaggerParameters())
                .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo = ApiInfoBuilder()
            .description(getSwaggerDetails().description)
            .license(getSwaggerDetails().license)
            .contact(Contact(getSwaggerDetails().contact.name, getSwaggerDetails().contact.website, getSwaggerDetails().contact.email))
            .licenseUrl(getSwaggerDetails().licenseUrl)
            .title(getSwaggerDetails().title)
            .build()

    protected fun createParameter(name: String, type: String, paramType: String, defVal: String, required: Boolean): Parameter {
        return ParameterBuilder()
                .name(name)
                .modelRef(ModelRef(type))
                .parameterType(paramType)
                .defaultValue(defVal)
                .required(required)
                .build()
    }

}
