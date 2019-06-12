package panda.repositories;

import panda.domain.entities.Package;
import panda.domain.models.view.PackageDetailsViewModel;

import javax.ejb.Stateless;

@Stateless
public class PackageRepositoryImpl extends BaseCrudRepository<Package, String> implements PackageRepository {

    @Override
    public PackageDetailsViewModel findByIdWithUser(String id) {
        return super.entityManager
                .createQuery("" +
                        "SELECT new panda.domain.models.view.PackageDetailsViewModel(p.description, p.weight, p.shippingAddress, p.status, p.estimatedDeliveryDate, p.recipient.username) FROM Package p " +
                        "WHERE p.id = :id", PackageDetailsViewModel.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
