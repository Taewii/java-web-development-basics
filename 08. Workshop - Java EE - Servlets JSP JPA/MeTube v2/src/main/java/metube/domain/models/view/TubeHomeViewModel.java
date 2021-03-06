package metube.domain.models.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import metube.domain.entities.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TubeHomeViewModel {

    private String id;
    private String title;
    private User uploader;
    private String youtubeId;
}
