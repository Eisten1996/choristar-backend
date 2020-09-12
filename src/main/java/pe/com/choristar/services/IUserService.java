package pe.com.choristar.services;

import pe.com.choristar.models.User;

public interface IUserService {


    public User saveUser(User user);

    public boolean existDni(String dni);

    public boolean existEmail(String email);
}
