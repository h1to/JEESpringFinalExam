package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Role;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.RoleRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class RoleServiceTest {
    @Mock
    RoleRepoImpl roleRepo;
    @InjectMocks
    RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRole() {
        when(roleRepo.save(any())).thenReturn(0);
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        int result = roleService.addRole(new Role(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(roleRepo.update(any())).thenReturn(0);
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        int result = roleService.rename(new Role(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteRole() {
        when(roleRepo.delete(anyLong())).thenReturn(0);
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        int result = roleService.deleteRole(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetRoleList() {
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        List<Role> result = roleService.getRoleList();
        Assertions.assertEquals(List.of(new Role(Long.valueOf(1), "name")), result);
    }

    @Test
    void testRoleExists() {
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        boolean result = roleService.roleExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetRoleById() {
        when(roleRepo.findAll()).thenReturn(List.of(new Role(Long.valueOf(1), "name")));

        Role result = roleService.getRoleById(Long.valueOf(1));
        Assertions.assertEquals(new Role(Long.valueOf(1), "name"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme