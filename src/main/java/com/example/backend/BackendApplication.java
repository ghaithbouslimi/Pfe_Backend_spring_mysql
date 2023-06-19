package com.example.backend;


import com.example.backend.ServicesProduction.XmlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@SpringBootApplication
public class BackendApplication  {

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}
}
//	@Override
//	public void run(String... args) {
//		String filePath = "D:/projet du PFE/Stage Socket/SocketPanaLog.txt";
//		fileDateChecker.checkFileForDate(filePath);
//	}
//	@Bean
//	CommandLineRunner runer(ServiceUsPicklist serviceUsPicklist) {
//		return args -> {
//			ObjectMapper mapper = new ObjectMapper();
//			com.fasterxml.jackson.core.type.TypeReference<List<Us_Picklist>> typeReference =
//					new TypeReference<List<Us_Picklist>>() {};
//			InputStream inputStream = Type.class.getResourceAsStream("/src/main/json/UsPicklist.json");
//			try {
//				List<Us_Picklist> picklists = mapper.readValue(inputStream, typeReference);
//				serviceUsPicklist.save(picklists);
//				System.out.println( "data saved" );
//			} catch (IOException e) {
//				System.out.println( "enabele to save data" + e.getMessage());
//			}
//		};
//	}







