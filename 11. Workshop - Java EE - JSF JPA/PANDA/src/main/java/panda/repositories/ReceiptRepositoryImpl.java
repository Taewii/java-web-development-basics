package panda.repositories;

import panda.domain.entities.Receipt;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ReceiptRepositoryImpl extends BaseCrudRepository<Receipt, String> implements ReceiptRepository {

    @Override
    public List<Receipt> findAllWithUser() {
        return super.entityManager
                .createQuery("" +
                        "SELECT r FROM Receipt r " +
                        "JOIN FETCH r.recipient " +
                        "ORDER BY r.issuedOn DESC ", Receipt.class)
                .getResultList();
    }

    @Override
    public List<Receipt> findByUserIdWithUser(String userId) {
        return super.entityManager
                .createQuery("" +
                        "SELECT r FROM Receipt r " +
                        "JOIN FETCH r.recipient " +
                        "WHERE r.recipient.id = :id " +
                        "ORDER BY r.issuedOn DESC", Receipt.class)
                .setParameter("id", userId)
                .getResultList();
    }

    @Override
    public Receipt findByReceiptIdEager(String receiptId) {
        return super.entityManager
                .createQuery("" +
                        "SELECT r FROM Receipt r " +
                        "JOIN FETCH r.recipient " +
                        "JOIN FETCH r.packet " +
                        "WHERE r.id = :id", Receipt.class)
                .setParameter("id", receiptId)
                .getSingleResult();
    }
}
