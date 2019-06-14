package panda.domain.models.view.receipts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReceiptDetailsViewModel {

    private String id;
    private LocalDateTime issuedOn;
    private String packetShippingAddress;
    private Double packetWeight;
    private String packetDescription;
    private String recipientUsername;
    private BigDecimal fee;
}
