package io.java.springbootalbum;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import io.java.springbootalbum.model.Album;
import io.java.springbootalbum.model.User;

@RestController
public class DataController {

	private final RestTemplate restTemplate;

	public DataController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	// this method is used to get the albums of a specific user
	// i am specifying that the type of the method is get, it could be post,delete.. all what you have to do is change RequestMethod.(XX)
	@RequestMapping(value = "/UserAlbum/{id}", method = RequestMethod.GET)
	public Album[] getAlbumOfUsers(@PathVariable("id") int id) {
		try {
			String url = "https://jsonplaceholder.typicode.com/users/{id}/albums";
			return this.restTemplate.getForObject(url, Album[].class, id);

		} catch (HttpStatusCodeException ex) {

			// raw http status code e.g `404`
			System.out.println(ex.getRawStatusCode());
			// http status code e.g. `404 NOT_FOUND`
			System.out.println(ex.getStatusCode().toString());
			// get response body
			System.out.println(ex.getResponseBodyAsString());
			// get http headers
			HttpHeaders headers = ex.getResponseHeaders();
			System.out.println(headers.get("Content-Type"));
			System.out.println(headers.get("Server"));

		}

		return null;

	}

	// this method returns all the users
	// i am specifying that the type of the method is get, it could be post,delete..
	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public User[] getAllUsers() {
		try {
			String url = "https://jsonplaceholder.typicode.com/users/";
			return this.restTemplate.getForObject(url, User[].class);

		} catch (HttpStatusCodeException ex) {
			System.out.println(ex.getRawStatusCode());
			System.out.println(ex.getStatusCode().toString());
			System.out.println(ex.getResponseBodyAsString());
			HttpHeaders headers = ex.getResponseHeaders();
			System.out.println(headers.get("Content-Type"));
			System.out.println(headers.get("Server"));
		}

		return null;
	}

	// this method returns all the Albums
	// i am specifying that the type of the method is get, it could be post,delete..
	@RequestMapping(value = "/Albums", method = RequestMethod.GET)
	public Album[] getAllAlbums() {
		try {
			String url = "https://jsonplaceholder.typicode.com/albums/";
			return this.restTemplate.getForObject(url, Album[].class);

		} catch (HttpStatusCodeException ex) {
			System.out.println(ex.getRawStatusCode());
			System.out.println(ex.getStatusCode().toString());
			System.out.println(ex.getResponseBodyAsString());
			HttpHeaders headers = ex.getResponseHeaders();
			System.out.println(headers.get("Content-Type"));
			System.out.println(headers.get("Server"));
		}

		return null;
	}

}
