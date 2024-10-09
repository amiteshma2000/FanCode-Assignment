package endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class Endpoints {

//	to get all available user details 
	public static Response getAllUsers() {
		Response res = given().when().get(Routes.users);
		return res;
	}

//	to get all available todos 
	public static Response getAllTodos() {
		Response res = given().when().get(Routes.todos);
		return res;
	}

// 	to get todos fro specific user by passing userId as QueryParam
	public static Response getSpecificUserTodos(int id) {

		Response res = given().queryParam("userId", id).when().get(Routes.todos);
		return res;
	}

//	to get all comments
	public static Response getComments() {

		Response res = given().when().get(Routes.comments);
		return res;
	}

//	to get all posts
	public static Response getPosts() {
		Response res = given().when().get(Routes.posts);
		return res;
	}

//	to get all albums
	public static Response getAlbums() {

		Response res = given().when().get(Routes.albums);
		return res;
	}
}
