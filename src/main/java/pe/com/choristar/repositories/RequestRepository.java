package pe.com.choristar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.com.choristar.models.Request;

public interface RequestRepository extends MongoRepository<Request, String> {
}
