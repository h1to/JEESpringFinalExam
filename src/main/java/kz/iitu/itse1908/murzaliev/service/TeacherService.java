package kz.iitu.itse1908.murzaliev.service;

import kz.iitu.itse1908.murzaliev.entity.Teacher;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.TeacherRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    
    private TeacherRepoImpl teacherRepo;

    @Autowired
    public void setTeacherRepo(TeacherRepoImpl teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public int addTeacher(Teacher teacher) {
        List<Teacher> teacherList = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teacherList.stream().filter(d -> d.getTeacherId()== teacher.getTeacherId()).findFirst();
        if (optionalTeacher.isPresent()) {
            return 10;
        }
        else {
            return teacherRepo.save(teacher);
        }
    }

    public int rename(Teacher teacher) {
        List<Teacher> teacherList = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teacherList.stream().filter(d -> d.getTeacherId()== teacher.getTeacherId()).findFirst();
        if (optionalTeacher.isPresent()) {
            return 10;
        }
        else {
            return teacherRepo.update(teacher);
        }
    }

    public int deleteTeacher(Long id) {
        List<Teacher> teacherList = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teacherList.stream().filter(d -> d.getTeacherId() == id).findFirst();
        if (optionalTeacher.isPresent()) {
            return teacherRepo.delete(id);
        }
        else {
            return 11;
        }
    }

    public boolean teacherExists (Long id) {
        boolean result = false;
        List<Teacher> teachers = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teachers.stream().filter(s -> s.getTeacherId() == id).findFirst();
        if (optionalTeacher.isPresent()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public List<Teacher> getTeacherList () {
        return teacherRepo.findAll();
    }

    public Teacher getTeacherById(Long id) {
        List<Teacher> teacherList = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teacherList.stream().filter(d -> d.getTeacherId() == id).findFirst();
        if (optionalTeacher.isPresent()) {
            return optionalTeacher.get();
        }
        else  {
            return new Teacher();
        }
    }

    public Teacher getByUser (Long userId) {
        List<Teacher> teacherList = teacherRepo.findAll();
        Optional<Teacher> optionalTeacher = teacherList.stream().filter(u -> u.getUser().getUserId() == userId).findFirst();
        if (optionalTeacher.isPresent()) {
            return optionalTeacher.get();
        }
        else  {
            return new Teacher();
        }
    }
}
