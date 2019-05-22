package metube.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class TubeBindingModel {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Pattern(regexp = "https://www.youtube.com/watch\\?v=[A-Za-z0-9-]{11}")
    private String youtubeLink;

    @NotBlank
    private String uploader;
}
