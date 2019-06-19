package exodia.services;

import exodia.domain.models.binding.ScheduleDocumentBindingModel;
import exodia.domain.models.view.DocumentIndexViewModel;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Optional<String> schedule(ScheduleDocumentBindingModel model);

    <M> M findById(String id, Class<M> target);

    List<DocumentIndexViewModel> findAllIndexView();

    Optional<byte[]> getPdf(String documentId);

    void print(String documentId);
}
