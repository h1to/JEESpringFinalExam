package kz.iitu.itse1908.murzaliev.AOP.afterAdvice;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Grades;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.GradesRepoImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterStudentAdding {

    private GradesRepoImpl gradesRepo;

    @Autowired
    public void setGradesRepo(GradesRepoImpl gradesRepo) {
        this.gradesRepo = gradesRepo;
    }

    @After("kz.iitu.itse1908.murzaliev.AOP.pointcut.Pointcuts.addGradeList(students,discipline)")
    public void createGradeList(JoinPoint jp, List<Student> students, Discipline discipline) {
        List<Grades> gradesInDB = gradesRepo.findByDiscipline(discipline.getDiscipline_id());
        for (int i = 0; i < gradesInDB.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (gradesInDB.get(i).getStudent().getStudentId() == students.get(j).getStudentId()) {
                    students.remove(students.get(j));
                }
            }
        }

        students.forEach(s -> {
            gradesRepo.save(new Grades(discipline,s));
        });
    }
}
