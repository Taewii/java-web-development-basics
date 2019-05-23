package metube.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UploadTubeBindingModel {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String youtubeId;

    private String description;
}
