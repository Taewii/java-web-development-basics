package panda.repositories;

import panda.domain.entities.Package;

import javax.ejb.Stateless;

@Stateless
public class PackageRepositoryImpl extends BaseCrudRepository<Package, String> implements PackageRepository {
}
