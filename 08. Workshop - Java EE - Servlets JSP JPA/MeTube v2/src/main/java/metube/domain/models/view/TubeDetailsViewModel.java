package metube.domain.models.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TubeDetailsViewModel {

    private String title;
    private String author;
    private String youtubeId;
    private String description;
    private long views;
}
