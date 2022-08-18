package com.registro.usuario.repositories;

import com.registro.usuario.models.User;

public interface IAuthUserRepository {

    User getUserAuth(User user);
}
