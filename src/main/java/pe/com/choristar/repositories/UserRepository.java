package pe.com.choristar.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.com.choristar.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByDni(String dni);

    public User findByEmail(String dni);

    public User findByEmailAndPassword(String email, String password);

}
