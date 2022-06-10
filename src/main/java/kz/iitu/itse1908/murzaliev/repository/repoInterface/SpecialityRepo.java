package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Speciality;

import java.util.List;

public interface SpecialityRepo {

    int save(Speciality speciality);
    int update(Speciality speciality);
    int delete(Long id);
    Speciality findById(Long id);
    List<Speciality> findAll();
}
