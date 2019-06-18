package exodia.services;

import com.qkyrie.markdown2pdf.internal.converting.Html2PdfConverter;
import com.qkyrie.markdown2pdf.internal.converting.Markdown2HtmlConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import exodia.domain.entities.Document;
import exodia.domain.models.binding.ScheduleDocumentBindingModel;
import exodia.domain.models.view.DocumentDetailsViewModel;
import exodia.domain.models.view.DocumentIndexViewModel;
import exodia.repositories.DocumentRepository;
import exodia.util.ModelValidator;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final Html2PdfConverter html2PdfConverter;
    private final Markdown2HtmlConverter markdown2HtmlConverter;
    private final ModelMapper mapper;

    @Inject
    public DocumentServiceImpl(DocumentRepository documentRepository,
                               Html2PdfConverter html2PdfConverter,
                               Markdown2HtmlConverter markdown2HtmlConverter,
                               ModelMapper mapper) {
        this.documentRepository = documentRepository;
        this.html2PdfConverter = html2PdfConverter;
        this.markdown2HtmlConverter = markdown2HtmlConverter;
        this.mapper = mapper;
    }

    @Override
    public Optional<String> schedule(ScheduleDocumentBindingModel model) {
        if (ModelValidator.validateModel(model) != null) {
            return Optional.empty();
        }

        return Optional.of(this.documentRepository.update(this.mapper.map(model, Document.class)).getId());
    }

    @Override
    public <M> M findById(String id, Class<M> target) {
        return this.mapper.map(this.documentRepository.findOne(id), target);
    }

    @Override
    public List<DocumentIndexViewModel> findAllIndexView() {
        return this.documentRepository.findAll().stream()
                .map(document -> this.mapper.map(document, DocumentIndexViewModel.class))
                .peek(doc -> {
                    if (doc.getTitle().length() > 12) {
                        doc.setTitle(doc.getTitle().substring(0, 12) + "...");
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void getPdf(String documentId) {
        DocumentDetailsViewModel doc = this.findById(documentId, DocumentDetailsViewModel.class);
        String content = String.format("<h1 style=\"text-align: center;\">%s</h1>\n", doc.getTitle()) + doc.getContent();

        try {
            String html = this.markdown2HtmlConverter.convert(content);
            html = "<div>" + html
                    .replaceAll("(?<=<h[0-6])>", " style=\"text-align: center;\">")
                    .replaceAll("(?<=</h[0-6])>", ">\n<hr />\n")
                    + "</div>";
            byte[] bytes = this.html2PdfConverter.convert(html);
            FileOutputStream fos = new FileOutputStream("E:\\SoftUni\\java-web-development-basics\\Exams\\24 February 2019 - Exodia\\EXODIA\\src\\main\\webapp\\resources\\test.pdf");
            fos.write(bytes);
            fos.close();
        } catch (ConversionException | IOException e) {
            e.printStackTrace();
        }
    }
}
