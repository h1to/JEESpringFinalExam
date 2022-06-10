package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Degree;

import java.util.List;

public interface DegreeRepo {
    int save(Degree degree);
    int update(Degree degree);

    int delete(Long id);

    Degree findById(Long id);

    List<Degree> findAll();
}
