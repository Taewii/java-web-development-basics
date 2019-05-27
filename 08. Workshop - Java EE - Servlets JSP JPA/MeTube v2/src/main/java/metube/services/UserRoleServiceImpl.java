package metube.services;

import metube.domain.entities.Role;
import metube.domain.enums.UserRole;
import metube.repositories.UserRoleRepository;

import javax.inject.Inject;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Inject
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void save(Role role) {
        this.userRoleRepository.save(role);
    }

    @Override
    public Role findByType(UserRole type) {
        return this.userRoleRepository.findByType(type);
    }
}
