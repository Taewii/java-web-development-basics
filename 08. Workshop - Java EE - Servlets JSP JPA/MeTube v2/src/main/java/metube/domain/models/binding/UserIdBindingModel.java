package metube.domain.models.binding;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserIdBindingModel {

    @NonNull
    private String id;
}
