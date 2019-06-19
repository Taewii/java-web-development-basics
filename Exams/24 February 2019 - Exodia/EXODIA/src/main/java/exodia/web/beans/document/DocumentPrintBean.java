package exodia.web.beans.document;

import exodia.domain.models.view.DocumentPrintViewModel;
import exodia.services.DocumentService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.OutputStream;

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

    public void print() {
        String id = super.externalContext.getRequestParameterMap().get("id");
        this.documentService.print(id);
        super.redirect("/");
    }

    public void getAsPdf() {
        String id = super.externalContext.getRequestParameterMap().get("id");
        String documentName = "document-" + id.substring(0, 8);

        this.documentService.getPdf(id).ifPresentOrElse(pdf -> {
            FacesContext fc = super.facesContext;
            ExternalContext ec = super.externalContext;
            ec.responseReset();
            ec.setResponseContentType("application/pdf");
            ec.setResponseHeader("Content-Disposition", "attachment; filename=" + documentName + ".pdf");

            OutputStream output;
            try {
                output = ec.getResponseOutputStream();
                output.write(pdf);
            } catch (IOException e) {
                e.printStackTrace();
            }

            fc.responseComplete();
        }, super.addMessageRunnable("Something is wrong with the formatting of the document, extraction is not possible."));
    }
}
