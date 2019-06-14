package panda.repositories;

import panda.domain.entities.Receipt;

import java.util.List;

public interface ReceiptRepository extends CrudRepository<Receipt, String> {

    List<Receipt> findByUserIdWithUser(String userId);

    List<Receipt> findAllWithUser();

    Receipt findByReceiptIdEager(String receiptId);
}
