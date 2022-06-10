package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Department;
import kz.iitu.itse1908.murzaliev.entity.Faculty;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.FacultyRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    
    private FacultyRepoImpl facultyRepo;

    @Autowired
    public void setFacultyRepo(FacultyRepoImpl facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public int addFaculty(Faculty faculty) {
        List<Faculty> facultyList = facultyRepo.findAll();
        Optional<Faculty> optionalFaculty = facultyList.stream().filter(d -> d.getName().equals(faculty.getName()) || d.getFacultyId() == faculty.getFacultyId()).findFirst();
        if (optionalFaculty.isPresent()) {
            return 10;
        }
        else {
            return facultyRepo.save(faculty);
        }
    }

    public int rename(Faculty faculty) {
        List<Faculty> FacultyList = facultyRepo.findAll();
        Optional<Faculty> optionalFaculty = FacultyList.stream().filter(d -> d.getName().equals(faculty.getName())).findFirst();
        if (optionalFaculty.isPresent()) {
            return 10;
        }
        else {
            return facultyRepo.update(faculty);
        }
    }

    public boolean facultyExists (Long id) {
        boolean result = false;
        List<Faculty> faculties = facultyRepo.findAll();
        Optional<Faculty> optionalDepartment = faculties.stream().filter(d -> d.getFacultyId() == id).findFirst();
        if (optionalDepartment.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public int deleteFaculty(Long id) {
        List<Faculty> FacultyList = facultyRepo.findAll();
        Optional<Faculty> optionalFaculty = FacultyList.stream().filter(d -> d.getFacultyId() == id).findFirst();
        if (optionalFaculty.isPresent()) {
            return facultyRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public List<Faculty> getFacultyList () {
        List<Faculty> facultyList = facultyRepo.findAll();
        return facultyList;
    }

    public Faculty getFacultyById(Long id) {
        List<Faculty> facultyList = facultyRepo.findAll();
        Optional<Faculty> optionalFaculty = facultyList.stream().filter(d -> d.getFacultyId() == id).findFirst();
        if (optionalFaculty.isPresent()) {
            return optionalFaculty.get();
        }
        else  {
            return new Faculty();
        }
    }
}
