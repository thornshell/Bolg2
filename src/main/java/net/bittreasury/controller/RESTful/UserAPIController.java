package net.bittreasury.controller.RESTful;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bittreasury.entity.User;
import net.bittreasury.service.UserService;

@RestController
public class UserAPIController {

	@Autowired
	private UserService userService;

	@RequestMapping("api/getUserById/{id}")
	public User getUserById(@PathVariable Long id) {
		User userById = userService.getUserById(id);
		return userById;
	}

	@RequestMapping("api/getAllAuthors")
	public List<User> getAllAuthors() {
		List<User> allUsers = userService.getAllUsers();
		return allUsers;
	}

	@RequestMapping("api/getRandomUser/{count}")
	public List<User> getRandomUser(@PathVariable("count") Integer count) {
		List<User> randomUsers = userService.getRandomUsers(count);
		return randomUsers;
	}

	@RequestMapping("api/user")
	public User usertest() {
		User acount = (User) SecurityUtils.getSubject().getPrincipal();
		return acount;
	}

	@RequestMapping("api/addUser")
	public User addUser(User user) {
		user.setRegistratioDate(new Date());
		User addUser = userService.addUser(user);
		return addUser;
	}

}
