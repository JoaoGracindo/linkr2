package app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import app.api.DTOs.AuthenticationDTO;
import app.api.DTOs.SignupDTO;
import app.api.infra.TokenService;
import app.api.models.Users;
import app.api.repositories.UsersRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = (Users) authenticationManager.authenticate(usernamePassword).getPrincipal();
        String token = tokenService.generateToken(auth);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@Validated @RequestBody SignupDTO data) {
        if (this.usersRepository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users user = new Users(data.name(), encryptedPassword, data.email(), data.picUrl());
        this.usersRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
