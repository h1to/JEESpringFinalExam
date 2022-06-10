package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Role;

import java.util.List;

public interface RoleRepo {

    int save(Role role);
    int update(Role role);
    int delete(Long id);
    Role findById(Long id);
    List<Role> findAll();
}
