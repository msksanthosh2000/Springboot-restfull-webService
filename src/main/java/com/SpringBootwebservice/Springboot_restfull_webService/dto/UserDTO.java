package com.SpringBootwebservice.Springboot_restfull_webService.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;

    @Schema(
            description = "FirstName"
    )
    @NotNull(message = "First Name must not be empty")
    private String firstName;

    @Schema(
            description = "LastName"
    )
    @NotNull(message = "Last Name must not be empty")
    private String lastName;

    @Schema(
            description = "Email"
    )
    @NotNull(message = "email must not be empty")
    @Email
    private String email;
}
