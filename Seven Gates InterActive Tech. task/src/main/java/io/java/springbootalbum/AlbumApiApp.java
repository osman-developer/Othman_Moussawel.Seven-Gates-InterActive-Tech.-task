package io.java.springbootalbum;

import org.springframework.boot.SpringApplication;	
import org.springframework.boot.autoconfigure.SpringBootApplication;
//this annotation tells that this is the starting point of our spring app
@SpringBootApplication
public class AlbumApiApp {

	public static void main(String[] args) {
		//it starts the app
		SpringApplication.run(AlbumApiApp.class,args);
	
	}

}
