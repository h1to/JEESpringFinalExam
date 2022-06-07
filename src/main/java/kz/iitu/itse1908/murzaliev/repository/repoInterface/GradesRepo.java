package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Grades;

import java.util.List;

public interface GradesRepo {

    int save(Grades grades);
    int update(Grades grades);
    int delete(Long id);
    Grades findById(Long id);
    List<Grades> findAll();
}
