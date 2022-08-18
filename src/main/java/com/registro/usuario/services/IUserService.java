package com.registro.usuario.services;

import com.registro.usuario.models.User;

import java.util.List;

public interface IUserService {

    List<User> list();
    User searchUser(Long id);
    User saveUser(User user);
    User editUser(User user);
    void deleteUser(Long Id);
    Boolean authToken(String token);

}
