package fdmc.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatViewModel {

    private String name;
    private String breed;
    private String color;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
}
