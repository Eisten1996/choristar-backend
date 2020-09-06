package pe.com.choristar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.com.choristar.models.Request;

import java.util.List;

public interface RequestRepository extends MongoRepository<Request, String> {
    List<Request> findByUser(String user);
}
