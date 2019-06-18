package exodia.web.beans.document;

import exodia.domain.models.binding.ScheduleDocumentBindingModel;
import exodia.services.DocumentService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.IOException;

@Model
@NoArgsConstructor
public class ScheduleDocumentBean extends BaseBean {

    private ScheduleDocumentBindingModel model = new ScheduleDocumentBindingModel();

    private DocumentService documentService;

    @Inject
    public ScheduleDocumentBean(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void schedule() {
        this.documentService.schedule(this.model).ifPresentOrElse(docId -> {
            try {
                super.externalContext.redirect("/details?id=" + docId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, super.addMessageRunnable("Something went wrong. Please try again."));
    }

    public ScheduleDocumentBindingModel getModel() {
        return this.model;
    }
}
