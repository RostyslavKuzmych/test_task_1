package application.service.abstraction;

import application.dto.internal.UserLoginRequestDto;
import application.dto.internal.UserLoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
