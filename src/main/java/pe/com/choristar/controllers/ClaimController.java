package pe.com.choristar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Claim;
import pe.com.choristar.models.Request;
import pe.com.choristar.repositories.ClaimRepository;
import pe.com.choristar.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api")
public class ClaimController {

    Logger logger = LoggerFactory.getLogger(ClaimRepository.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClaimRepository claimRepository;

    @PostMapping("/claim/{dni}")
    public ResponseEntity<Claim> createClaim(@PathVariable String dni, @RequestBody Claim claim) {
        claim.setUser(userRepository.findByDni(dni).getId());
        logger.info(userRepository.findByDni(dni).toString());
        try {
            Claim _claim = claimRepository.save(new Claim(claim.getDateClaim(), claim.getTypeClaim(), claim.getUser(), claim.getStateClaim()));

            return new ResponseEntity<>(_claim, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/claim")
    public ResponseEntity<List<Claim>> getAllClaim() {
        try {
            List<Claim> claims = new ArrayList<>();
            claimRepository.findAll().forEach(claims::add);
            if (claims.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(claims, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
