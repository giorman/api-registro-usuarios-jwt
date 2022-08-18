package com.registro.usuario.services;

import com.registro.usuario.models.User;

public interface IAuthUserService {
    User Auth(User user);
}
