package panda.domain.models.view.packets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PackagePendingAndDeliveredViewModel {

    private String id;
    private String description;
    private Double weight;
    private String shippingAddress;
    private String recipientUsername;
}
