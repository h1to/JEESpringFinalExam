package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Department;
import kz.iitu.itse1908.murzaliev.entity.Department;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DepartmentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Lazy
@Service
public class DepartmentService {
    
    private DepartmentRepoImpl departmentRepo;

    @Autowired
    public void setDepartmentRepo(DepartmentRepoImpl departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public int addDepartment(Department department) {
        List<Department> departmentList = departmentRepo.findAll();
        Optional<Department> optionalDepartment = departmentList.stream().filter(d -> d.getName().equals(department.getName()) || d.getDepartmentId() == department.getDepartmentId()).findFirst();
        if (optionalDepartment.isPresent()) {
            return 10;
        }
        else {
            return departmentRepo.save(department);
        }
    }

    public int rename(Department department) {
        List<Department> DepartmentList = departmentRepo.findAll();
        Optional<Department> optionalDepartment = DepartmentList.stream().filter(d -> d.getName().equals(department.getName())).findFirst();
        if (optionalDepartment.isPresent()) {
            return 10;
        }
        else {
            return departmentRepo.update(department);
        }
    }

    public boolean departmentExists (Long id) {
        boolean result = false;
        List<Department> departmentList = departmentRepo.findAll();
        Optional<Department> optionalDepartment = departmentList.stream().filter(d -> d.getDepartmentId() == id).findFirst();
        if (optionalDepartment.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public int deleteDepartment(Long id) {
        List<Department> DepartmentList = departmentRepo.findAll();
        Optional<Department> optionalDepartment = DepartmentList.stream().filter(d -> d.getDepartmentId() == id).findFirst();
        if (optionalDepartment.isPresent()) {
            return departmentRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public List<Department> getDepartmentList () {
        List<Department> departmentList = departmentRepo.findAll();
        return departmentList;
    }

    public Department getDepartmentById(Long id) {
        List<Department> departmentList = departmentRepo.findAll();
        Optional<Department> optionalDepartment = departmentList.stream().filter(d -> d.getDepartmentId() == id).findFirst();
        if (optionalDepartment.isPresent()) {
            return optionalDepartment.get();
        }
        else  {
            return new Department();
        }
    }
}
