package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DegreeRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepoImpl degreeRepo;

    public int save(Degree degree) {
        return degreeRepo.save(degree);
    }

    public int update(Degree degree) {
        return degreeRepo.update(degree);
    }
}
