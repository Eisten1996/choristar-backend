package pe.com.choristar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.com.choristar.models.Claim;

import java.util.List;

public interface ClaimRepository extends MongoRepository<Claim, String> {
    List<Claim> findByUser(String user);
}
