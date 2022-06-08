package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Student;

import java.util.List;

public interface StudentRepo {

    int save(Student student);
    int update(Student student);
    int delete(Long id);
    Student findById(Long id);
    List<Student> findAll();
}
