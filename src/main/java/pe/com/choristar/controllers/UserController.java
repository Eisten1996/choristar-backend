package pe.com.choristar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Claim;
import pe.com.choristar.models.Request;
import pe.com.choristar.models.User;
import pe.com.choristar.repositories.ClaimRepository;
import pe.com.choristar.repositories.RequestRepository;
import pe.com.choristar.repositories.UserRepository;
import pe.com.choristar.services.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.existDni(user.getDni()) && userService.existEmail(user.getEmail())) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            User _user = userService.saveUser(new User(user.getDni(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                    user.getDateBirth(), user.getStateUser(), user.getTypeUser(), user.getServices()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        Optional<User> user = userRepository.findById(id);

        if (user != null) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserDni(@RequestParam(value = "dni") String dni) {
        User user = userRepository.findByDni(dni);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        try {
            userRepository.deleteById(id);
            List<Claim> claim = claimRepository.findByUser(id);
            List<Request> requests = requestRepository.findByUser(id);
            if (!claim.isEmpty()) {
                claimRepository.deleteAll(claim);
            }
            if (!requests.isEmpty()) {
                requestRepository.deleteAll(requests);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setDni(user.getDni());
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setDateBirth(user.getDateBirth());
            _user.setTypeUser(user.getTypeUser());
            _user.setStateUser(user.getStateUser());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
