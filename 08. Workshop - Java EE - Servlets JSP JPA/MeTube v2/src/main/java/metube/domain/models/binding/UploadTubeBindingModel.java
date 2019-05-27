package metube.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UploadTubeBindingModel {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String youtubeId;

    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYoutubeId(String youtubeId) {
       this.youtubeId = youtubeId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
