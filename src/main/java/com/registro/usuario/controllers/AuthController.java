package com.registro.usuario.controllers;

import com.registro.usuario.models.User;
import com.registro.usuario.services.IAuthUserService;
import com.registro.usuario.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class AuthController {

    @Autowired
    private IAuthUserService iAuthUserService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<?> Login(@RequestBody User user){
        User userLogueado =  iAuthUserService.Auth(user);
       if (userLogueado != null){
        String token = jwtUtils.create(String.valueOf(userLogueado.getId()), userLogueado.getEmail());
        return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
       }else {
           return new ResponseEntity<>("FAIL", HttpStatus.UNAUTHORIZED);
       }

    }



}


