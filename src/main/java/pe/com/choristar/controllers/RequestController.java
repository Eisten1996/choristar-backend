package pe.com.choristar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Request;
import pe.com.choristar.models.User;
import pe.com.choristar.repositories.ClaimRepository;
import pe.com.choristar.repositories.RequestRepository;
import pe.com.choristar.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RequestController {

    Logger logger = LoggerFactory.getLogger(ClaimRepository.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestRepository requestRepository;

    @PostMapping("/request/{dni}")
    public ResponseEntity<Request> createRequest(@PathVariable String dni, @RequestBody Request request) {

        request.setUser(userRepository.findByDni(dni).getId());
        logger.info(userRepository.findByDni(dni).toString());
        try {
            Request _request = requestRepository.save(new Request(request.getDateRequest(), request.getTypeRequest(), request.getUser(), request.getStateRequest()));

            return new ResponseEntity<>(_request, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/request")
    public ResponseEntity<List<Request>> getAllRequest() {
        try {
            List<Request> requests = new ArrayList<>();
            requestRepository.findAll().forEach(requests::add);
            if (requests.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
