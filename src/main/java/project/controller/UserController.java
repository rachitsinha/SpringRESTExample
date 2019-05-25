package project.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.model.RequestModel;
import project.model.User;
import project.service.UserService;

@Controller
@RequestMapping(value= "/userservice")
public class UserController {
	
	private UserService userService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "Welcome to SpringRESTExample User Service.";
	}
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"} )
	@ResponseBody
	public User getUserById(@PathVariable String id) {
		return this.userService.getUserById(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/json", "application/xml"} )
	@ResponseBody
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@RequestBody RequestModel request) {
		return this.userService.deleteUserById(request.getUid());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@RequestBody User user) {
		return this.userService.updateUserById(user.getUid(), user);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<User> searchUser(@RequestBody RequestModel request) {
		return this.userService.searchUser(request.getSearchText());
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
