package application.controller;

import application.dto.internal.UserLoginRequestDto;
import application.dto.internal.UserLoginResponseDto;
import application.dto.internal.UserRegistrationRequestDto;
import application.dto.internal.UserResponseDto;
import application.exception.RegistrationLogicException;
import application.service.abstraction.AuthenticationService;
import application.service.abstraction.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "User management", description = "Endpoints for user management")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Authenticate user", description = "Endpoint for user authentication")
    public UserResponseDto register(@RequestBody @Valid
                                    UserRegistrationRequestDto requestDto) throws RegistrationLogicException {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Endpoint for user login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
