package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Speciality;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.SpecialityRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService {
    
    private SpecialityRepoImpl specialityRepo;

    @Autowired
    public void setSpecialityRepo(SpecialityRepoImpl specialityRepo) {
        this.specialityRepo = specialityRepo;
    }

    public int addSpeciality(Speciality speciality) {
        List<Speciality> specialityList = specialityRepo.findAll();
        Optional<Speciality> optionalSpeciality = specialityList.stream().filter(d -> d.getSpecialityId()== speciality.getSpecialityId()).findFirst();
        if (optionalSpeciality.isPresent()) {
            return 10;
        }
        else {
            return specialityRepo.save(speciality);
        }
    }

    public int rename(Speciality speciality) {
        List<Speciality> specialityList = specialityRepo.findAll();
        Optional<Speciality> optionalSpeciality = specialityList.stream().filter(d -> d.getSpecialityId()== speciality.getSpecialityId()).findFirst();
        if (optionalSpeciality.isPresent()) {
            return 10;
        }
        else {
            return specialityRepo.update(speciality);
        }
    }

    public int deleteSpeciality(Long id) {
        List<Speciality> specialityList = specialityRepo.findAll();
        Optional<Speciality> optionalSpeciality = specialityList.stream().filter(d -> d.getSpecialityId() == id).findFirst();
        if (optionalSpeciality.isPresent()) {
            return specialityRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public boolean specialityExists (Long id) {
        boolean result = false;
        List<Speciality> specialitys = specialityRepo.findAll();
        Optional<Speciality> optionalSpeciality = specialitys.stream().filter(s -> s.getSpecialityId() == id).findFirst();
        if (optionalSpeciality.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public List<Speciality> getSpecialityList () {
        return specialityRepo.findAll();
    }

    public Speciality getSpecialityById(Long id) {
        List<Speciality> specialityList = specialityRepo.findAll();
        Optional<Speciality> optionalSpeciality = specialityList.stream().filter(d -> d.getSpecialityId() == id).findFirst();
        if (optionalSpeciality.isPresent()) {
            return optionalSpeciality.get();
        }
        else  {
            return new Speciality();
        }
    }
}
