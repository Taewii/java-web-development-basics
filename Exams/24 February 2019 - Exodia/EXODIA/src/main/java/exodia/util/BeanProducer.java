package exodia.util;

import com.qkyrie.markdown2pdf.Markdown2PdfConverter;
import com.qkyrie.markdown2pdf.internal.converting.Html2PdfConverter;
import com.qkyrie.markdown2pdf.internal.converting.Markdown2HtmlConverter;
import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class BeanProducer {

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Produces
    public Markdown2PdfConverter markdown2PdfConverter() {
        return Markdown2PdfConverter.newConverter();
    }

    @Produces
    public Markdown2HtmlConverter markdown2HtmlConverter() {
        return new Markdown2HtmlConverter();
    }

    @Produces
    public Html2PdfConverter html2PdfConverter() {
        return new Html2PdfConverter();
    }
}
