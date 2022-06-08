package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DegreeRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeService {
    @Autowired
    private DegreeRepoImpl degreeRepo;

    public int addDegree(Degree degree) {
        List<Degree> degreeList = degreeRepo.findAll();
        Optional<Degree> optionalDegree = degreeList.stream().filter(d -> d.getName().equals(degree.getName())).findFirst();
        if (optionalDegree.isPresent()) {
            return 10;
        }
        else {
            return degreeRepo.save(degree);
        }
    }

    public int rename(Degree degree) {
        List<Degree> degreeList = degreeRepo.findAll();
        Optional<Degree> optionalDegree = degreeList.stream().filter(d -> d.getName().equals(degree.getName())).findFirst();
        if (optionalDegree.isPresent()) {
            return 10;
        }
        else {
            return degreeRepo.update(degree);
        }
    }

    public int deleteDegree(Long id) {
        List<Degree> degreeList = degreeRepo.findAll();
        Optional<Degree> optionalDegree = degreeList.stream().filter(d -> d.getDegreeId() == id).findFirst();
        if (optionalDegree.isPresent()) {
            return degreeRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public List<Degree> getDegreeList () {
        List<Degree> degreeList = degreeRepo.findAll();
        return degreeList;
    }

    public Degree getDegreeById(Long id) {
        List<Degree> degreeList = degreeRepo.findAll();
        Optional<Degree> optionalDegree = degreeList.stream().filter(d -> d.getDegreeId() == id).findFirst();
        if (optionalDegree.isPresent()) {
            return optionalDegree.get();
        }
        else  {
            return new Degree();
        }
    }
}
