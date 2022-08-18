package com.registro.usuario.services;

import com.registro.usuario.models.User;
import com.registro.usuario.repositories.IUserRepository;
import com.registro.usuario.utils.JWTUtils;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    private JWTUtils jwtutils;

    @Override
    public List<User> list() {
        return iUserRepository.getUsers();
    }

    @Override
    public User searchUser(Long id) {
        return iUserRepository.search(id);
    }

    @Override
    public User saveUser(User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        return iUserRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return iUserRepository.edit(user);
    }

    @Override
    public void deleteUser(Long id) {
        iUserRepository.delete(id);
    }

    @Override
    public Boolean authToken(String token) {
           String usuarioID = jwtutils.getKey(token);
            return usuarioID != null;
    }
}