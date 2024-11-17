package application.mapper;

import application.config.CustomMapperConfig;
import application.dto.internal.UserRegistrationRequestDto;
import application.dto.internal.UserResponseDto;
import application.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CustomMapperConfig.class)
public interface UserMapper {
     UserEntity toModel(UserRegistrationRequestDto userRegistrationRequestDto);

     UserResponseDto toDto(UserEntity userEntity);
}

