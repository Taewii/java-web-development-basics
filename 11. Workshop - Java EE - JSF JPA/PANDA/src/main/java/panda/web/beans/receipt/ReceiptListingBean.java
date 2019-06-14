package panda.web.beans.receipt;

import lombok.NoArgsConstructor;
import panda.domain.models.view.ReceiptListViewModel;
import panda.services.ReceiptService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class ReceiptListingBean extends BaseBean {

    private ReceiptService receiptService;

    @Inject
    public ReceiptListingBean(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    public List<ReceiptListViewModel> getAdminView() {
        return Collections.unmodifiableList(this.receiptService.findAll());
    }

    public List<ReceiptListViewModel> getAllByUserId(String userId) {
        return Collections.unmodifiableList(this.receiptService.findByUserId(userId));
    }
}
