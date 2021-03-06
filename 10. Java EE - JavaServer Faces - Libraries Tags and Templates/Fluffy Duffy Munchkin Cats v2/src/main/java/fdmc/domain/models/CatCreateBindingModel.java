package fdmc.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatCreateBindingModel {

    @Size(min = 2, max = 10)
    private String name;

    @Size(min = 5, max = 20)
    private String breed;

    @NotBlank
    private String color;

    @Min(1)
    @Max(31)
    private Integer age;

    @NotBlank
    private String gender;

    @DecimalMin("0.01")
    private BigDecimal price;

    @NotNull
    private Date addedOn;

    @NotNull
    private Boolean hasPassport;
}
