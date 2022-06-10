package kz.iitu.itse1908.murzaliev.utility;

import kz.iitu.itse1908.murzaliev.entity.Discipline;
import kz.iitu.itse1908.murzaliev.entity.Student;
import kz.iitu.itse1908.murzaliev.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuickSort {

    public static void quickSortStudent(List<Student> students, int low, int high) {
        if (students.size() == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Student opora = students.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (students.get(i).getStudentId() < opora.getStudentId()) {
                i++;
            }

            while (students.get(j).getStudentId() > opora.getStudentId()) {
                j--;
            }

            if (i <= j) {//меняем местами
                Student temp = students.get(i);
                students.add(i,students.get(j));
                students.add(j,temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortStudent(students, low, j);

        if (high > i)
            quickSortStudent(students, i, high);
    }

    public static void quickSortTeacher(List<Teacher> teachers, int low, int high) {
        if (teachers.size() == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Teacher opora = teachers.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (teachers.get(i).getTeacherId() < opora.getTeacherId()) {
                i++;
            }

            while (teachers.get(j).getTeacherId() > opora.getTeacherId()) {
                j--;
            }

            if (i <= j) {//меняем местами
                Teacher temp = teachers.get(i);
                teachers.add(i,teachers.get(j));
                teachers.add(j,temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortTeacher(teachers, low, j);

        if (high > i)
            quickSortTeacher(teachers, i, high);
    }

    public static void quickSortDiscipline(List<Discipline> disciplines, int low, int high) {
        if (disciplines.size() == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Discipline opora = disciplines.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (disciplines.get(i).getDiscipline_id() < opora.getDiscipline_id()) {
                i++;
            }

            while (disciplines.get(j).getDiscipline_id() > opora.getDiscipline_id()) {
                j--;
            }

            if (i <= j) {//меняем местами
                Discipline temp = disciplines.get(i);
                disciplines.add(i,disciplines.get(j));
                disciplines.add(j,temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortDiscipline(disciplines, low, j);

        if (high > i)
            quickSortDiscipline(disciplines, i, high);
    }
}
