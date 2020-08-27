package pe.com.choristar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.choristar.models.User;
import pe.com.choristar.repositories.UserRepository;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity<User> createTutorial(@RequestBody User user) {
		try {
			User _user = userRepository.save(new User(user.getDni(), user.getFirstName(), user.getLastName(),
					user.getEmail(), user.getDateBirth(), user.getStateUser(), user.getTypeUser(), user.getServices()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
