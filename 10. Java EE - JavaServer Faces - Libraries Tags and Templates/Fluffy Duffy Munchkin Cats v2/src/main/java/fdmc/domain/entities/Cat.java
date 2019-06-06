package fdmc.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private String id;

    @Column
    @Size(min = 2, max = 10)
    private String name;

    @Column
    @Size(min = 5, max = 20)
    private String breed;

    @Column(nullable = false)
    private String color;

    @Min(1)
    @Max(31)
    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String gender;

    @DecimalMin("0.01")
    @Column(nullable = false)
    private BigDecimal price;

    @PastOrPresent
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date addedOn;

    @Column(nullable = false)
    private Boolean hasPassport;
}
