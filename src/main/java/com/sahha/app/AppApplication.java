package com.sahha.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.sahha.app.constant.SwaggerConstant.*;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = TITLE, version = VERSION, description = DESCRIPTION,
		contact = @Contact(name = CONTACT_NAME, url = CONTACT_URL)
))
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}