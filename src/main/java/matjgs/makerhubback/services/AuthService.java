package matjgs.makerhubback.services;

import matjgs.makerhubback.models.dto.AuthDTO;
import matjgs.makerhubback.models.form.LoginForm;

public interface AuthService {
    AuthDTO login(LoginForm form);


    AuthDTO refreshJWT(String refreshToken);
}
