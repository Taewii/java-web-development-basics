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

    public void setYoutubeId(String youtubeLink) {
        String videoId = youtubeLink.split("v=")[1];
        int ampersandPosition = videoId.indexOf('&');
        if (ampersandPosition != -1) {
            videoId = videoId.substring(0, ampersandPosition);
        }

        this.youtubeId = videoId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
