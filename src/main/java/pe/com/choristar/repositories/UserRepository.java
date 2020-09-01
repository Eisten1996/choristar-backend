package pe.com.choristar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import pe.com.choristar.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByDni(String dni);

}
