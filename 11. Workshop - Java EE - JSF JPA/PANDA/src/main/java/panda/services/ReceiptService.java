package panda.services;

import panda.domain.models.view.receipts.ReceiptDetailsViewModel;
import panda.domain.models.view.receipts.ReceiptListViewModel;

import java.util.List;

public interface ReceiptService {

    List<ReceiptListViewModel> findAll();

    List<ReceiptListViewModel> findByUserId(String id);

    ReceiptDetailsViewModel findByReceiptIdEager(String receiptId);
}
