package panda.services;

import panda.domain.entities.Receipt;
import panda.repositories.ReceiptRepository;

import javax.inject.Inject;

public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Inject
    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public void save(Receipt receipt) {
        this.receiptRepository.save(receipt);
    }
}
