package application.service.abstraction;

import application.dto.internal.UserRegistrationRequestDto;
import application.dto.internal.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
