package application.dto.internal;

import application.validation.FieldMatch;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Accessors(chain = true)
@FieldMatch
public class UserRegistrationRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 4)
    private String password;

    @NotBlank
    @Size(min = 4)
    private String repeatPassword;
}


