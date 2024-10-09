package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.restassured.response.Response;
import endpoints.Endpoints;
import io.cucumber.java.en.*;

public class TodosCompletionSteps {
//  List to hold All users and filtered users who belong to the city FanCode
	List<Map<String, Object>> allUsers = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> filteredUsers = new ArrayList<Map<String, Object>>();

	@Given("User has the todo tasks")
	public void user_has_the_todo_tasks() {
//		API call get all users and to retrieve the entire JSON response as a list
		Response resUser = Endpoints.getAllUsers();
		Assert.assertEquals(resUser.getStatusCode(), 200);
		this.allUsers = resUser.jsonPath().getList("$");
	}

	@And("User belongs to the city FanCode")
	public void user_belongs_to_the_city_fan_code() {
		double latMin = -40.0;
		double latMax = 5.0;
		double lngMin = 5.0;
		double lngMax = 100.0;
//		Iterate over each user
		for (Map<String, Object> user : allUsers) {
//			Get the address information
			Map<String, Object> address = (Map<String, Object>) user.get("address");
			if (address != null) {
				Map<String, Object> geo = (Map<String, Object>) address.get("geo");
				double lat = Double.parseDouble(geo.get("lat").toString());
				double lng = Double.parseDouble(geo.get("lng").toString());

//				Check if the user's lat and lng are within the specified ranges
				if (lat > latMin && lat < latMax && lng > lngMin && lng < lngMax) {
					// Add the user to the filtered list
					filteredUsers.add(user);
				}
			}
		}
	}

	@Then("User Completed task percentage should be greater than {int}%")
	public void user_completed_task_percentage_should_be_greater_than(Integer int1) {
//		API call get all todos and to retrieve the entire JSON response as a list
		Response resTodos = Endpoints.getAllTodos();
		Assert.assertEquals(resTodos.getStatusCode(), 200);
		List<Map<String, Object>> todos = resTodos.jsonPath().getList("$");
//		Printing user completion percentages in a formatted way on Console
		System.out.println("User Completion Percentages:");
		System.out.printf("%-25s %s%n", "User Name", "Completion Percentage");
		System.out.println("---------------------------------------");

//		iterating over each user in the filteredUsers list
		for (Map<String, Object> user : filteredUsers) {
			int userId = (Integer) user.get("id");
			int totalTasks = 0;
			int completedTasks = 0;

//			iterating over list of todos to check task completion status
			for (Map<String, Object> task : todos) {
				if ((Integer) task.get("userId") == userId) {
					totalTasks++;
					if ((Boolean) task.get("completed")) {
						completedTasks++;
					}
				}
			}
//			calculating the completion percentage of todos for a user
			double completionPercentage = ((double) completedTasks / totalTasks) * 100;
			// Print formatted output with username and completionPercentage
			System.out.printf("%-25s %.2f%%%n", user.get("name"), completionPercentage);

//			assertion to check if the completion percentage of todos is greater than 50%
			Assert.assertTrue(completionPercentage > 50);
		}
	}
}
