package kz.iitu.itse1908.murzaliev.AOP.beforeAdvice;

import kz.iitu.itse1908.murzaliev.service.DisciplineService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeDeletingFromDiscipline {

    private DisciplineService disciplineService;

    @Autowired
    public void setDisciplineRepo(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @Before("kz.iitu.itse1908.murzaliev.AOP.pointcut.Pointcuts.deleteDiscipline(id)")
    public void beforeDeleteDiscipline (JoinPoint jp,Long id) {
        disciplineService.deleteDisciplineFromDS(id);
        disciplineService.deleteDisciplineFromDT(id);
    }
}
