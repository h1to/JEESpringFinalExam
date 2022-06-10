package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Faculty;

import java.util.List;

public interface FacultyRepo {

    int save(Faculty faculty);
    int update(Faculty faculty);
    int delete(Long id);
    Faculty findById(Long id);
    List<Faculty> findAll();
}
