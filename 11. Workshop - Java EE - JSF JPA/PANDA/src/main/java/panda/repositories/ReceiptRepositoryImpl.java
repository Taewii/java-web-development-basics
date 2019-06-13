package panda.repositories;

import panda.domain.entities.Receipt;

import javax.ejb.Stateless;

@Stateless
public class ReceiptRepositoryImpl extends BaseCrudRepository<Receipt, String> implements ReceiptRepository {
}
