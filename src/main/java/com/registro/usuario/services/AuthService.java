package com.registro.usuario.services;

import com.registro.usuario.models.User;
import com.registro.usuario.repositories.IAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthUserService{

    @Autowired
    IAuthUserRepository iAuthUserRepository;

    @Override
    public User Auth(User user) {
        return iAuthUserRepository.getUserAuth(user) ;
    }
}
