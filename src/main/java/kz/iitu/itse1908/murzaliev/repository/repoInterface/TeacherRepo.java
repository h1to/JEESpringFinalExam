package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Teacher;

import java.util.List;

public interface TeacherRepo {

    int save(Teacher teacher);
    int update(Teacher teacher);
    int delete(Long id);
    Teacher findById(Long id);
    List<Teacher> findAll();
}
