package panda.repositories;

import panda.domain.entities.Package;
import panda.domain.enums.Status;
import panda.domain.models.view.packets.PackageDetailsViewModel;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PackageRepositoryImpl extends BaseCrudRepository<Package, String> implements PackageRepository {

    @Override
    public PackageDetailsViewModel findByIdWithUser(String id) {
        return super.entityManager
                .createQuery("" +
                        "SELECT new panda.domain.models.view.packets.PackageDetailsViewModel(p.description, p.weight, p.shippingAddress, p.status, p.estimatedDeliveryDate, p.recipient.username) " +
                        "FROM Package p " +
                        "WHERE p.id = :id", PackageDetailsViewModel.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Package> findAllByStatusEager(Status status) {
        return super.entityManager
                .createQuery("" +
                        "SELECT p FROM Package p " +
                        "JOIN FETCH p.recipient " +
                        "WHERE p.status = :status", Package.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Package> findAllByStatusAndUserId(Status status, String userId) {
        return super.entityManager
                .createQuery("" +
                        "SELECT p FROM Package p " +
                        "WHERE p.status = :status " +
                        "AND p.recipient.id = :userId", Package.class)
                .setParameter("status", status)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Package findByIdEager(String id) {
        return super.entityManager
                .createQuery("" +
                        "SELECT p FROM Package p " +
                        "JOIN FETCH p.recipient " +
                        "WHERE p.id = :id", Package.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
