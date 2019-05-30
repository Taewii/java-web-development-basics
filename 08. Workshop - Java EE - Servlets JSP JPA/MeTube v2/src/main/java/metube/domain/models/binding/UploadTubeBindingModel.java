package metube.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import metube.domain.enums.TubeStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private UserIdBindingModel uploader;

    private TubeStatus status = TubeStatus.PENDING;
}
