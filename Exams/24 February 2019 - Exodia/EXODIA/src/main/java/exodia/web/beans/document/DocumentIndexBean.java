package exodia.web.beans.document;

import exodia.domain.models.view.DocumentIndexViewModel;
import exodia.services.DocumentService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class DocumentIndexBean extends BaseBean {

    private List<DocumentIndexViewModel> documents;

    private DocumentService documentService;

    @Inject
    public DocumentIndexBean(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostConstruct
    private void init() {
        this.documents = this.documentService.findAllIndexView();
    }

    public List<DocumentIndexViewModel> getDocuments() {
        return Collections.unmodifiableList(this.documents);
    }
}
