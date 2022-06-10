package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Department;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DepartmentRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class DepartmentServiceTest {
    @Mock
    DepartmentRepoImpl departmentRepo;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddDepartment() {
        when(departmentRepo.save(any())).thenReturn(0);
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        int result = departmentService.addDepartment(new Department(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testRename() {
        when(departmentRepo.update(any())).thenReturn(0);
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        int result = departmentService.rename(new Department(Long.valueOf(1), "name"));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDepartmentExists() {
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        boolean result = departmentService.departmentExists(Long.valueOf(1));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteDepartment() {
        when(departmentRepo.delete(anyLong())).thenReturn(0);
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        int result = departmentService.deleteDepartment(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetDepartmentList() {
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        List<Department> result = departmentService.getDepartmentList();
        Assertions.assertEquals(List.of(new Department(Long.valueOf(1), "name")), result);
    }

    @Test
    void testGetDepartmentById() {
        when(departmentRepo.findAll()).thenReturn(List.of(new Department(Long.valueOf(1), "name")));

        Department result = departmentService.getDepartmentById(Long.valueOf(1));
        Assertions.assertEquals(new Department(Long.valueOf(1), "name"), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme