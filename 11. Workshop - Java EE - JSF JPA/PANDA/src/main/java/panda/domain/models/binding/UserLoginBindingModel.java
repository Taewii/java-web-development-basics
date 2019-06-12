package panda.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
