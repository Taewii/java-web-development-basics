package panda.domain.models.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptListViewModel {

    private String id;
    private BigDecimal fee;
    private LocalDateTime issuedOn;
    private String recipientUsername;
}
