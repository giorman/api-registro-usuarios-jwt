package com.registro.usuario.repositories;

import com.registro.usuario.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthUserRepository implements IAuthUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserAuth(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> lista = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if (lista.isEmpty()){
            return null;
        }
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, user.getPassword())){

            return lista.get(0);
        }
        return null;
    }
}
