package kz.iitu.itse1908.murzaliev.AOP.pointcut;


import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import org.apache.catalina.LifecycleState;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

@Aspect
@Component
public class Pointcuts {

    @Pointcut("execution(* kz.iitu.itse1908.murzaliev.service.DisciplineService.addStudents(..)) && args(students,discipline)")
    public void addGradeList (List<Student>students, Discipline discipline) {
    }

    @Pointcut("execution(* kz.iitu.itse1908.murzaliev.service.DisciplineService.deleteDescipline(..)) && args(id)")
    public void deleteDiscipline (Long id){
    }
}
