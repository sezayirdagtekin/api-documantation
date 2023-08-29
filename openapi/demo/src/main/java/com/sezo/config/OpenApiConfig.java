package com.sezo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	   info = @Info(
						contact = @Contact(name = "Sezayir", email = "contactme@gmail.com", url = "https://springdoc.org/"),
						description = "OpenApi documentation for Springboot", title = "Open Api Specification", 
						version = "1.0",
						license = @License(name = "Licence @sezo", url = "http://somelicens.com"), 
						termsOfService = "Terms of service!"), 
	   servers = {
				@Server(description = "local", url = "http://localhost:8080"),
				@Server(description = "dev", url = "http://dev:8080"), 
			  })
public class OpenApiConfig {

}
