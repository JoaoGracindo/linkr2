package app.api.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import app.api.models.Users;

@Service
public class TokenService {

    @Value("${app.jwt.key}")
    private String key;

    public String generateToken(Users user) {
        try {
            String token = JWT.create()
                    .withSubject(user.getUsername())
                    .sign(Algorithm.HMAC512(key));
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token.", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(key);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Error while validating token.", e);
        }
    }

}
