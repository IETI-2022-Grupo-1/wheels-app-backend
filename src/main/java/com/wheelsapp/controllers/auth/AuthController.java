package com.wheelsapp.controllers.auth;

import java.util.Date;
import java.util.Calendar;
import io.jsonwebtoken.Jwts;
import com.wheelsapp.dto.auth.LoginDto;
import com.wheelsapp.dto.auth.TokenDto;
import com.wheelsapp.entities.users.User;
import io.jsonwebtoken.SignatureAlgorithm;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.services.users.UserService;
import com.wheelsapp.exception.ExceptionGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.wheelsapp.utils.constants.Constants.CLAIMS_ROLES_KEY;
import static com.wheelsapp.utils.constants.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Value( "${app.secret}" )
    String secret;

    private final UserService userService;

    public AuthController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            return generateTokenDto(user);
        } else {
            throw ExceptionGenerator.getException(ExceptionType.INVALID_CREDENTIALS, "Invalid credentials");
        }
    }

    private String generateToken(User user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(User user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}
