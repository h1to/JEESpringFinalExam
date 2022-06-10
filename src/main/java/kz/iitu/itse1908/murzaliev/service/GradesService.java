package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.configuration.CurrentWeekAndYear;
import kz.iitu.itse1908.murzaliev.entity.Grades;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.GradesRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    private CurrentWeekAndYear currentWeekAndYear;
    private GradesRepoImpl gradesRepo;
    private StudentService studentService;
    private DisciplineService disciplineService;

    @Autowired
    public void setDisciplineService(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setGradesRepo(GradesRepoImpl gradesRepo) {
        this.gradesRepo = gradesRepo;
    }

    @Autowired
    public void setCurrentWeekAndYear(CurrentWeekAndYear currentWeekAndYear) {
        this.currentWeekAndYear = currentWeekAndYear;
    }

    public int update (Grades grades) {
        if (currentWeekAndYear.getWeek()==16) {
            return 100;
        }
        else {
            return gradesRepo.update(grades);
        }
    }

    public Grades getGrades (Long studentId, Long disciplineId) {
        if (studentService.studentExists(studentId) && disciplineService.disciplineExists(disciplineId)) {
            return gradesRepo.findById(studentId,disciplineId);
        }
        else {
            return new Grades();
        }
    }

    public List<Grades> getGradesList (Long studentId) {
        List<Student> students = studentService.getStudentList();
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getStudentId() == studentId).findFirst();
        if (optionalStudent.isPresent()) {
            return gradesRepo.findByStudent(studentId);
        }
        else {
            return new ArrayList<>();
        }
    }
}
