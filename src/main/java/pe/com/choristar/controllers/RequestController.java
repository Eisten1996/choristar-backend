package pe.com.choristar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Request;
import pe.com.choristar.repositories.RequestRepository;
import pe.com.choristar.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RequestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestRepository requestRepository;

    @PostMapping("/request/{dni}")
    public ResponseEntity<Request> createRequest(@PathVariable String dni, @RequestBody Request request) {

        request.setUser(userRepository.findByDni(dni).getId());
        try {
            Request _request = requestRepository.save(new Request(request.getDateRequest(), request.getTypeRequest(), request.getUser(), request.getStateRequest()));

            return new ResponseEntity<>(_request, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/requests")
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

    @DeleteMapping("/request/{id}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable("id") String id) {
        try {
            requestRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/request/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable("id") String id, @RequestBody Request request) {
        Optional<Request> requestData = requestRepository.findById(id);
        if (requestData.isPresent()) {
            Request _request = requestData.get();
            _request.setDateRequest(request.getDateRequest());
            _request.setTypeRequest(request.getTypeRequest());
            _request.setStateRequest(request.getStateRequest());
            return new ResponseEntity<>(requestRepository.save(_request), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
