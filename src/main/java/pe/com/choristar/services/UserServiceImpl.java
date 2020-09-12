package pe.com.choristar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.choristar.models.User;
import pe.com.choristar.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean existDni(String dni) {
        if (userRepository.findByDni(dni) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean existEmail(String email) {
        if (userRepository.findByEmail(email) == null) {
            return false;
        } else {
            return true;
        }
    }
}
