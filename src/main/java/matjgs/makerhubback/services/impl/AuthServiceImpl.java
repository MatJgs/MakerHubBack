package matjgs.makerhubback.services.impl;

import matjgs.makerhubback.config.security.JwtProvider;
import matjgs.makerhubback.exceptions.InvalidRefreshTokenException;
import matjgs.makerhubback.models.dto.AuthDTO;
import matjgs.makerhubback.models.form.LoginForm;
import matjgs.makerhubback.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthDTO login(LoginForm form) {
        // create an Authentication object with the user's credentials
        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
//        form.setPassword(null); // clear password for security reasons

        // authenticate the user's credentials with the AuthenticationManager
        auth = authManager.authenticate(auth); // if invalid credentials, AuthenticationException is thrown.

        // generate a JWT using the authenticated user's data
        String accessToken = jwtProvider.generateAccessToken(auth);
        String refreshToken = jwtProvider.generateRefreshToken(auth);

        // build and return an AuthDTO object containing the authenticated user's username, role, and JWT
        return AuthDTO.from(auth, accessToken, refreshToken);
    }


    @Override
    public AuthDTO refreshJWT(String refreshToken) {

        if( refreshToken != null ){

            refreshToken = refreshToken.replaceFirst("Bearer ", "");
            if(jwtProvider.validateRefreshToken(refreshToken) ){
                Authentication auth = jwtProvider.createAuthentication(refreshToken);
                return AuthDTO.from(auth, jwtProvider.generateAccessToken(auth), refreshToken);
            }

        }

        throw new InvalidRefreshTokenException(refreshToken);
    }

}