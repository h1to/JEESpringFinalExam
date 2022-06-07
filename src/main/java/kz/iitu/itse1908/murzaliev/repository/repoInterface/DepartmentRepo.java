package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.entity.Department;

import java.util.List;

public interface DepartmentRepo {
    int save(Department department);
    int update(Department department);
    int delete(Long id);
    Department findById(Long id);
    List<Department> findAll();
}
