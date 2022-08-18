package com.registro.usuario.repositories;

import com.registro.usuario.models.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUsers();

    User search(Long id);

    void delete(Long id);

    User save(User user);

    User edit(User user);


}
