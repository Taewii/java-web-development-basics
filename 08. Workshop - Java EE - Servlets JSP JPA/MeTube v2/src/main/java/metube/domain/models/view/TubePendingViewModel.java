package metube.domain.models.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TubePendingViewModel {

    private String id;
    private String title;
    private String author;
}
