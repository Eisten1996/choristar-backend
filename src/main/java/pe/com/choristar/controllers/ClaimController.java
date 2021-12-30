package pe.com.choristar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.choristar.models.Claim;
import pe.com.choristar.repositories.ClaimRepository;
import pe.com.choristar.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ClaimRepository claimRepository;

    @PostMapping("/claim/{dni}")
    public ResponseEntity<Claim> createClaim(@PathVariable String dni, @RequestBody Claim claim) {
        claim.setUser(userRepository.findByDni(dni).getId());
        try {
            Claim _claim = claimRepository.save(new Claim(claim.getDateClaim(), claim.getTypeClaim(), claim.getUser(), claim.getStateClaim()));

            return new ResponseEntity<>(_claim, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allClaims")
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

    @DeleteMapping("/claim/{id}")
    public ResponseEntity<HttpStatus> deleteClaim(@PathVariable("id") String id) {
        try {
            claimRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/claim/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable("id") String id, @RequestBody Claim claim) {
        Optional<Claim> claimData = claimRepository.findById(id);
        if (claimData.isPresent()) {
            Claim _claim = claimData.get();
            _claim.setDateClaim(claim.getDateClaim());
            _claim.setTypeClaim(claim.getTypeClaim());
            _claim.setStateClaim(claim.getStateClaim());
            return new ResponseEntity<>(claimRepository.save(_claim), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
