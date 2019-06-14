package panda.services;

import org.modelmapper.ModelMapper;
import panda.domain.models.view.receipts.ReceiptDetailsViewModel;
import panda.domain.models.view.receipts.ReceiptListViewModel;
import panda.repositories.ReceiptRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ModelMapper mapper;

    @Inject
    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ModelMapper mapper) {
        this.receiptRepository = receiptRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ReceiptListViewModel> findAll() {
        return this.receiptRepository
                .findAllWithUser()
                .stream()
                .map(receipt -> this.mapper.map(receipt, ReceiptListViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReceiptListViewModel> findByUserId(String id) {
        return this.receiptRepository
                .findByUserIdWithUser(id)
                .stream()
                .map(receipt -> this.mapper.map(receipt, ReceiptListViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDetailsViewModel findByReceiptIdEager(String receiptId) {
        return this.mapper.map(this.receiptRepository.findByReceiptIdEager(receiptId), ReceiptDetailsViewModel.class);
    }
}
