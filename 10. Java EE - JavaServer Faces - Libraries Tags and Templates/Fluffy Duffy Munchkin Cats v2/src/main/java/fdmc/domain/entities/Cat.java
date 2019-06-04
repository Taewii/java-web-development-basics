package fdmc.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private String name;

    @Column
    private String breed;

    @Column
    private String color;

    @Column
    private Integer age;

    @Column
    private String gender;

    @Column
    private BigDecimal price;

    @Column
    private Date addedOn;

    @Column
    private Boolean hasPassport;
}
