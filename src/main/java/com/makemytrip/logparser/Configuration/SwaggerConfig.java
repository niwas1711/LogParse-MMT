package com.makemytrip.logparser.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
	{
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					       .select()
					       .apis(RequestHandlerSelectors.basePackage("com.makemytrip.logparser"))
					       .paths(PathSelectors.any())
					       .paths(regex("/api/.*"))
					       .build()
					       .useDefaultResponseMessages(false)
					       .apiInfo(apiEndPointsInfo());
		}

		/**
		 * This method is for the presentation of swagger UI
		 */
		@Bean
		UiConfiguration uiConfig() {
			return UiConfigurationBuilder.builder()
					       .deepLinking(true)
					       .displayOperationId(false)
					       .defaultModelsExpandDepth(1)
					       .defaultModelExpandDepth(1)
					       .defaultModelRendering(ModelRendering.EXAMPLE)
					       .displayRequestDuration(false)
					       .docExpansion(DocExpansion.NONE)
					       .filter(false)
					       .maxDisplayedTags(0)
					       .operationsSorter(OperationsSorter.METHOD)
					       .showExtensions(false)
					       .tagsSorter(TagsSorter.ALPHA)
					       .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
					       .validatorUrl(null)
					       .build();
		}

		private ApiInfo apiEndPointsInfo() {
			return new ApiInfoBuilder()
					       .title("MakeMyTrip Log occurance Search REST API Application")
					       .description("\"REST API application for MakeMyTrip Log occurance Search solution\"")
					       .version("1.0")
					       .contact(new Contact("Niwas shashi", "", "niwash1711@gmail.com"))
					       .build();
		}
	}
