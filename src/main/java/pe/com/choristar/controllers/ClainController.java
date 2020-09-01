package pe.com.choristar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Claim;
import pe.com.choristar.models.User;
import pe.com.choristar.repositories.ClaimRepository;
import pe.com.choristar.repositories.UserRepository;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api2")
public class ClainController {

    Logger logger = LoggerFactory.getLogger(ClaimRepository.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClaimRepository claimRepository;

    @PostMapping("/claim/{dni}")
    public ResponseEntity<Claim> createUser(@PathVariable String dni, @RequestBody Claim claim) {
        User user = userRepository.findByDni(dni);
        claim.setUser(user);
        logger.info(user.toString());
        try {
            Claim _claim = claimRepository.save(new Claim(claim.getDateClaim(), claim.getTypeClaim(), claim.getUser(), claim.getStateClaim()));
            return new ResponseEntity<>(_claim, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
