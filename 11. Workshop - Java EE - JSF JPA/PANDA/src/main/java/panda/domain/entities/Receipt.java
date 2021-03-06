package panda.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipt extends BaseEntity {

    @DecimalMin("0")
    @Column(nullable = false)
    private BigDecimal fee;

    @Column(name = "issued_on", nullable = false)
    private LocalDateTime issuedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User recipient;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Package packet;
}
