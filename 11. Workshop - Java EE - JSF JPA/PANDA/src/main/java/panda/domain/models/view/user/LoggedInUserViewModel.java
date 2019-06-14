package panda.domain.models.view.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoggedInUserViewModel {

    private String id;
    private String username;
    private String role;
}
