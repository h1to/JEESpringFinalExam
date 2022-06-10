package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Grades;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.User;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private UserService userService;
    private StudentRepoImpl studentRepo;

    private DisciplineService disciplineService;

    private GradesService gradesService;

    @Autowired
    public StudentService(UserService userService, StudentRepoImpl studentRepo, DisciplineService disciplineService, GradesService gradesService) {
        this.userService = userService;
        this.studentRepo = studentRepo;
        this.disciplineService = disciplineService;
        this.gradesService = gradesService;
    }

    @Autowired
    public void setStudentRepo(StudentRepoImpl studentRepo) {
        this.studentRepo = studentRepo;
    }

    public int addStudent(Student student) {
        List<Student> studentList = studentRepo.findAll();
        Optional<Student> optionalStudent = studentList.stream().filter(d -> d.getStudentId()== student.getStudentId()).findFirst();
        if (optionalStudent.isPresent()) {
            return 10;
        }
        else {
            return studentRepo.save(student);
        }
    }

    public int rename(Student student) {
        List<Student> studentList = studentRepo.findAll();
        Optional<Student> optionalStudent = studentList.stream().filter(d -> d.getStudentId()== student.getStudentId()).findFirst();
        if (optionalStudent.isPresent()) {
            return 10;
        }
        else {
            return studentRepo.update(student);
        }
    }

    public int deleteStudent(Long id) {
        List<Student> studentList = studentRepo.findAll();
        Optional<Student> optionalStudent = studentList.stream().filter(d -> d.getStudentId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            return studentRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public Student getByUser (Long userId) {
        List<Student> students = studentRepo.findAll();
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getUser().getUserId() == userId).findFirst();
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else {
            return new Student();
        }
    }

    public boolean studentExists (Long id) {
        boolean result = false;
        List<Student> students = studentRepo.findAll();
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getStudentId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public List<Student> getStudentList () {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        List<Student> studentList = studentRepo.findAll();
        Optional<Student> optionalStudent = studentList.stream().filter(d -> d.getStudentId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        else  {
            return new Student();
        }
    }

    public Double getGPA (Long studentId) {
        Double gpa = 0.0;
        List<Student> studentList = studentRepo.findAll();
        Optional<Student> optionalStudent = studentList.stream().filter(d -> d.getStudentId() == studentId).findFirst();
        if (optionalStudent.isPresent()) {
            List<Grades> gradesList = gradesService.getGradesList(studentId);

            for (int i=0; i < gradesList.size(); i++) {
                gpa += gradesList.get(i).getFinalGrade();
            }
            gpa = gpa/gradesList.size();
            gpa = gpa*4/100;
            return gpa;
        }
        else  {
            return 11.0;
        }
    }
}
