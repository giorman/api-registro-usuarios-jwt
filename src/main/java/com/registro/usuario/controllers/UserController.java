package com.registro.usuario.controllers;

import com.registro.usuario.models.User;
import com.registro.usuario.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("search/list")
    ResponseEntity<?> getListUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!iUserService.authToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(iUserService.list(),HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    ResponseEntity<?> getUsuario(@PathVariable Long id,@RequestHeader(value = "Authorization") String token) {
        if (!iUserService.authToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(iUserService.searchUser(id),HttpStatus.OK);
    }

    @PostMapping("save/user")
    ResponseEntity<User> saveUser(@RequestBody User user) {

        return new ResponseEntity<>(iUserService.saveUser(user),HttpStatus.CREATED);
    }

    @PostMapping("edit/user")
    public ResponseEntity<User> edit(@RequestBody User user, @RequestHeader(value = "Authorization") String token) {
        if (!iUserService.authToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(iUserService.editUser(user),HttpStatus.OK) ;
    }

    @DeleteMapping("delete/user/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {
        if (!iUserService.authToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        iUserService.deleteUser(id);
        return new ResponseEntity<>("Delete",HttpStatus.OK);

    }



}
