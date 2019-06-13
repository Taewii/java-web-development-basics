package panda.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PackageShippedViewModel {

    private String id;
    private String description;
    private Double weight;
    private LocalDateTime estimatedDeliveryDate;
    private String recipientUsername;
}
