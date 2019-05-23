package metube.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RegisterBindingModel {

    @NotBlank
    private String username;

    @Size(min = 6)
    private String password;

    @Size(min = 6)
    private String confirmPassword;

    @NotBlank
    private String email;
}
