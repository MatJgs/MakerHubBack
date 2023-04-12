package matjgs.makerhubback.controller;

import matjgs.makerhubback.models.dto.AuthDTO;
import matjgs.makerhubback.models.form.LoginForm;
import matjgs.makerhubback.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return authService.login(form);
    }

    @GetMapping("/refresh")
    public AuthDTO refreshToken(@RequestHeader("X-Refresh-Token") String refreshToken){
        return authService.refreshJWT(refreshToken);
    }

}
