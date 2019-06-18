package exodia.web.beans.document;

import exodia.domain.models.view.DocumentPrintViewModel;
import exodia.services.DocumentService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class DocumentPrintBean extends BaseBean {

    private DocumentPrintViewModel model;

    private DocumentService documentService;

    @Inject
    public DocumentPrintBean(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostConstruct
    private void init() {
        String id = super.externalContext.getRequestParameterMap().get("id");
        this.model = this.documentService.findById(id, DocumentPrintViewModel.class);
    }

    public DocumentPrintViewModel getModel() {
        return this.model;
    }

    public void getAsPdf() {
        String id = super.externalContext.getRequestParameterMap().get("id");
        this.documentService.getPdf(id);
    }
}
