package kmitl.sci.cs.entp.rentalvehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kmitl.sci.cs.entp.rentalvehicle.model.PatchUserRequest;
import kmitl.sci.cs.entp.rentalvehicle.model.User;
import kmitl.sci.cs.entp.rentalvehicle.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("users/{id}")
	public User getUserId(@PathVariable("id") String userId) {
		return service.getUser(Long.valueOf(userId));
	}

	@GetMapping("users/fname/{fname}")
	public User getUserByFirstName(@PathVariable("fname") String firstName) {
		return service.getUserByFirstName(firstName);
	}
	
	@PostMapping("/addUser")
	public void create(@RequestBody User user) {
		service.create(user);
	}
	
	@PatchMapping("/update/{id}")
	public void update(@PathVariable("id") String userId, @RequestBody PatchUserRequest request) {
		User user = service.getUser(Long.valueOf(userId));
		if(user != null) {
			service.update(user, request);
		}
	}
	
	@DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String userId) {
		User user = service.getUser(Long.valueOf(userId));
		if (user != null) 
        	service.delete(Long.valueOf(userId));
    }
}

