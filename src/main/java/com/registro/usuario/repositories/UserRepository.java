package com.registro.usuario.repositories;

import com.registro.usuario.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public User search(Long id) {
        User user =entityManager.find(User.class,id);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User save(User user) {
      return   entityManager.merge(user);
    }

    @Override
    public User edit(User user) {
       User newUser= entityManager.merge(user);
       return  newUser;
    }




}
