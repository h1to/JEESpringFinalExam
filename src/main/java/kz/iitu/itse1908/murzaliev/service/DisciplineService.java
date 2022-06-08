package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DisciplineRepoImpl;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    
    private DisciplineRepoImpl disciplineRepo;

    @Autowired
    public void setDisciplineRepo(DisciplineRepoImpl disciplineRepo) {
        this.disciplineRepo = disciplineRepo;
    }

    public int addDescipline(Discipline discipline) {
        List<Discipline> desciplineList = disciplineRepo.findAll();
        Optional<Discipline> optionalDescipline = desciplineList.stream().filter(d -> d.getName().equals(discipline.getName()) || d.getDiscipline_id() == discipline.getDiscipline_id()).findFirst();
        if (optionalDescipline.isPresent()) {
            return 10;
        }
        else {
            return disciplineRepo.save(discipline);
        }
    }

    public int rename(Discipline discipline) {
        List<Discipline> DesciplineList = disciplineRepo.findAll();
        Optional<Discipline> optionalDescipline = DesciplineList.stream().filter(d -> d.getName().equals(discipline.getName())).findFirst();
        if (optionalDescipline.isPresent()) {
            return 10;
        }
        else {
            return disciplineRepo.update(discipline);
        }
    }

    public int deleteDescipline(Long id) {
        List<Discipline> DesciplineList = disciplineRepo.findAll();
        Optional<Discipline> optionalDescipline = DesciplineList.stream().filter(d -> d.getDiscipline_id() == id).findFirst();
        if (optionalDescipline.isPresent()) {
            return disciplineRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public List<Discipline> getDesciplineList () {
        List<Discipline> desciplineList = disciplineRepo.findAll();
        return desciplineList;
    }

    public Discipline getDesciplineById(Long id) {
        List<Discipline> desciplineList = disciplineRepo.findAll();
        Optional<Discipline> optionalDescipline = desciplineList.stream().filter(d -> d.getDiscipline_id() == id).findFirst();
        if (optionalDescipline.isPresent()) {
            return optionalDescipline.get();
        }
        else  {
            return new Discipline();
        }
    }

    public List<Student> getStudents (Long id) {
        return disciplineRepo.getStudents(id);
    }

    public List<Teacher> getTeachers (Long id) {
        return disciplineRepo.getTeachers(id);
    }

    public int[] addStudents (List<Student> students, Discipline discipline) {
        return disciplineRepo.addStudents(students, discipline);
    }

    public int[] addTeachers (List<Teacher> teachers, Discipline discipline) {
        return disciplineRepo.addTeachers(teachers, discipline);
    }
}
