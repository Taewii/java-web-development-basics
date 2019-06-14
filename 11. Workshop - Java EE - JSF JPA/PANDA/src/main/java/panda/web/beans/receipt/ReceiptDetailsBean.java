package panda.web.beans.receipt;

import lombok.NoArgsConstructor;
import panda.domain.models.view.ReceiptDetailsViewModel;
import panda.services.ReceiptService;
import panda.web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class ReceiptDetailsBean extends BaseBean {

    private ReceiptDetailsViewModel model;

    private ReceiptService receiptService;

    @Inject

    public ReceiptDetailsBean(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostConstruct
    private void init() {
        String receiptId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.model = this.receiptService.findByReceiptIdEager(receiptId);
    }

    public ReceiptDetailsViewModel getModel() {
        return this.model;
    }
}
