package exodia.web.beans.document;

import exodia.domain.models.view.DocumentDetailsViewModel;
import exodia.services.DocumentService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class DocumentDetailsBean extends BaseBean {

    private DocumentDetailsViewModel model;

    private DocumentService documentService;

    @Inject
    public DocumentDetailsBean(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostConstruct
    private void init() {
        String id = super.externalContext.getRequestParameterMap().get("id");
        this.model = this.documentService.findById(id, DocumentDetailsViewModel.class);
    }

    public DocumentDetailsViewModel getModel() {
        return this.model;
    }
}
