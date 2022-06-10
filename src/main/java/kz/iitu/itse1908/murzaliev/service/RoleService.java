package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.RoleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    
    private RoleRepoImpl roleRepo;

    @Autowired
    public void setRoleRepo(RoleRepoImpl roleRepo) {
        this.roleRepo = roleRepo;
    }

    public int addRole(Role role) {
        List<Role> degreeList = roleRepo.findAll();
        Optional<Role> optionalRole = degreeList.stream().filter(d -> d.getName().equals(role.getName())).findFirst();
        if (optionalRole.isPresent()) {
            return 10;
        }
        else {
            return roleRepo.save(role);
        }
    }

    public int rename(Role role) {
        List<Role> degreeList = roleRepo.findAll();
        Optional<Role> optionalRole = degreeList.stream().filter(d -> d.getName().equals(role.getName())).findFirst();
        if (optionalRole.isPresent()) {
            return 10;
        }
        else {
            return roleRepo.update(role);
        }
    }

    public int deleteRole(Long id) {
        List<Role> degreeList = roleRepo.findAll();
        Optional<Role> optionalRole = degreeList.stream().filter(d -> d.getRoleId() == id).findFirst();
        if (optionalRole.isPresent()) {
            return roleRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public List<Role> getRoleList () {
        List<Role> degreeList = roleRepo.findAll();
        return degreeList;
    }

    public boolean roleExists (Long id) {
        boolean result = false;
        List<Role> roles = roleRepo.findAll();
        Optional<Role> optionalRole = roles.stream().filter(s -> s.getRoleId() == id).findFirst();
        if (optionalRole.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public Role getRoleById(Long id) {
        List<Role> degreeList = roleRepo.findAll();
        Optional<Role> optionalRole = degreeList.stream().filter(d -> d.getRoleId() == id).findFirst();
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        else  {
            return new Role();
        }
    }
}
