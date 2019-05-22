package metube.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TubeDetailsViewModel {

    private String title;
    private String description;
    private String youtubeLink;
    private String uploader;
}
