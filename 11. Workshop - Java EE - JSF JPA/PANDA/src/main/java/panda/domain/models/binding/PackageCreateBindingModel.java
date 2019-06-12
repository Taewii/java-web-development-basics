package panda.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PackageCreateBindingModel {

    @NotBlank
    private String description;

    @Min(0)
    private Double weight;

    @NotBlank
    private String shippingAddress;

    @NotBlank
    private String recipient;
}
