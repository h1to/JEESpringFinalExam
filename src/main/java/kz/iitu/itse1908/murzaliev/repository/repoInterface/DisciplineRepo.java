package kz.iitu.itse1908.murzaliev.repository.repoInterface;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.Teacher;

import java.util.List;

public interface DisciplineRepo {

    int save(Discipline discipline);
    int update(Discipline discipline);
    int delete(Long id);
    List<Discipline> findAll();
    int[] addTeachers(List<Teacher> teachers, Discipline discipline);
    int[] addStudents(List<Student> students, Discipline discipline);
    int[] deleteTeachers(List<Teacher> teachers, Discipline discipline);
    int[] deleteStudents(List<Student> students, Discipline discipline);

    int deleteDisciplineFromDS(Long id);
    int deleteDisciplineFromDT(Long id);

    List<Student> getStudents(Long id);
    List<Teacher> getTeachers(Long id);
}
