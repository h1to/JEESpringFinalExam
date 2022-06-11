package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DisciplineRepoImpl;
import kz.iitu.itse1908.murzaliev.utility.QuickSort;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class DisciplineService {
    
    private DisciplineRepoImpl disciplineRepo;

    private QuickSort quickSort;

    @Autowired
    public void setQuickSort(QuickSort quickSort) {
        this.quickSort = quickSort;
    }

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

    public int deleteDisciplineFromDS(Long id) {
        List<Discipline> disciplines = disciplineRepo.findAll();
        Optional<Discipline> optionalDiscipline = disciplines.stream().filter(d -> d.getDiscipline_id() == id).findFirst();
        if (optionalDiscipline.isPresent()) {
            return disciplineRepo.deleteDisciplineFromDS(id);
        }
        else {
            return 11;
        }
    }

    public int deleteDisciplineFromDT(Long id) {
        List<Discipline> disciplines = disciplineRepo.findAll();
        Optional<Discipline> optionalDiscipline = disciplines.stream().filter(d -> d.getDiscipline_id() == id).findFirst();
        if (optionalDiscipline.isPresent()) {
            return disciplineRepo.deleteDisciplineFromDT(id);
        }
        else {
            return 11;
        }
    }

    public boolean disciplineExists (Long id) {
        boolean result = false;

        Optional<Discipline> discipline = disciplineRepo.findAll().stream().filter(d -> d.getDiscipline_id() == id).findFirst();
        if (discipline.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
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

    public List<Student> getStudentsByD (Long idD) {
        List<Student> students = disciplineRepo.getStudentsByD(idD);
        //quickSort.quickSortStudent(students,students.get(0).getStudentId().intValue(),students.get(students.size()-1).getStudentId().intValue());
        return students;
    }

    public List<Teacher> getTeachers (Long id) {
        List<Teacher> teachers = disciplineRepo.getTeachers(id);
        quickSort.quickSortTeacher(teachers,teachers.get(0).getTeacherId().intValue(),teachers.get(teachers.size()-1).getTeacherId().intValue());
        return teachers;
    }

    public int[] addStudents (List<Student> students, Discipline discipline) {
        List<Student> studentsInDB = disciplineRepo.getStudentsByD(discipline.getDiscipline_id());
        students.forEach(s -> {
            if (studentsInDB.contains(s)) {
                System.out.println("Student with id=" + s.getStudentId() + " already exists in discipline");
                students.remove(s);
            }
        });
        return disciplineRepo.addStudents(students, discipline);
    }

    public int[] addTeachers (List<Teacher> teachers, Discipline discipline) {
        List<Teacher> teachersInDB = disciplineRepo.getTeachers(discipline.getDiscipline_id());
        teachers.forEach(t -> {
            if (teachersInDB.contains(t)) {
                System.out.println("Discipline already contains teacher with id=" + t.getTeacherId());
                teachers.remove(t);
            }
        });
        return disciplineRepo.addTeachers(teachers, discipline);
    }

    public List<Discipline> getDByStudent (Long studentId) {
        List<Discipline> disciplines = getDesciplineList();
        for (int i = 0; i < disciplines.size(); i++) {
            List<Student> students = disciplines.get(i).getStudent();
            Optional<Student> student = students.stream().filter(s -> s.getStudentId() == studentId).findFirst();
            if (student.isEmpty()) {
                disciplines.remove(disciplines.get(i));
            }
        }
        return disciplines;
    }
}
