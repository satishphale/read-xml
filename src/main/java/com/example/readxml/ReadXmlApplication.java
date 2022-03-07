package com.example.readxml;

import com.example.readxml.model.Profile;
import com.example.readxml.service.ProfileService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.example.readxml" }, excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { PersistenceConfig.class })
//})
public class ReadXmlApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ReadXmlApplication.class, args);




	}

}
