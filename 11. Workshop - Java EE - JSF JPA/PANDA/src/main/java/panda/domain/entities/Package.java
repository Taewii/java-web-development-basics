package panda.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import panda.domain.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "packages")
public class Package extends BaseEntity {

    @Column
    private String description;

    @Min(0)
    @Column
    private Double weight;

    @NotNull
    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @FutureOrPresent
    @Column(name = "estimated_delivery_date")
    private LocalDateTime estimatedDeliveryDate;

    @OneToOne(mappedBy = "packet", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Receipt receipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User recipient;
}
