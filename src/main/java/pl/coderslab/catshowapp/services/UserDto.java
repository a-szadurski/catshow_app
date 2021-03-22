package pl.coderslab.catshowapp.services;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.catshowapp.validationcustom.PasswordMatches;
import pl.coderslab.catshowapp.validationcustom.ValidEmail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @NotNull(message = "{NotEmpty.user.password}")
    @Size(min = 8, max = 25)
    private String password;

    @NotNull(message = "{NotEmpty.user.matchingPassword}")
    @Size(min = 8, max = 25)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

}
