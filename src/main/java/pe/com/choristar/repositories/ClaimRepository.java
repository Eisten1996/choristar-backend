package pe.com.choristar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.com.choristar.models.Claim;

public interface ClaimRepository extends MongoRepository<Claim, String> {
}
