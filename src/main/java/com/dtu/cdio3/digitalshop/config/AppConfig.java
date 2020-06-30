package com.dtu.cdio3.digitalshop.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {
	@Bean
	public Docket api() {
		final String swaggerToken = "your token";  
		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(Collections.singletonList(
                    new ParameterBuilder()
                            .name("Authorization")
                            .modelRef(new ModelRef("string"))
                            .parameterType("header")
                            .required(true)
                            .hidden(true)
                            .defaultValue("Bearer " + swaggerToken)
                            .build()
                    )
            );
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
	    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setGenerateDdl(true);
	    jpaVendorAdapter.setShowSql(true);

	    return jpaVendorAdapter;
	}
}

