package application.service.impl;

import application.dto.internal.UserRegistrationRequestDto;
import application.dto.internal.UserResponseDto;
import application.exception.RegistrationLogicException;
import application.mapper.UserMapper;
import application.model.RoleEntity;
import application.model.UserEntity;
import application.repository.RoleRepository;
import application.repository.UserRepository;
import application.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String EXCEPTION = "You are already registered!";
    private static final String USER_ROLE_ID = "1";
    public static final String USER_ROLE_NAME = "USER";
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByUsername(requestDto.getUsername()).isPresent()) {
            throw new RegistrationLogicException(EXCEPTION);
        }

        UserEntity user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        if (roleRepository.findById(USER_ROLE_ID).isEmpty()) {
            roleRepository.save(new RoleEntity().setId(USER_ROLE_ID).setName(USER_ROLE_NAME));
        }

        user.setRoles(Set.of(USER_ROLE_ID));
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
