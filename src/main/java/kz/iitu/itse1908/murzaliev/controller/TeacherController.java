package kz.iitu.itse1908.murzaliev.controller;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.security.CustomOAuth2User;
import kz.iitu.itse1908.murzaliev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Scope("prototype")
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    DepartmentService departmentService;
    DegreeService degreeService;
    DisciplineService disciplineService;
    SpecialityService specialityService;
    FacultyService facultyService;
    RoleService roleService;
    UserService userService;
    StudentService studentService;
    TeacherService teacherService;
    GradesService gradesService;

    private Teacher getAuthenticatedTeacher () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        String email = oauthUser.getEmail();
        User user = userService.getByEmail(email);
        Teacher teacher = teacherService.getByUser(user.getUserId());
        if (!(teacher.getTeacherId() == null)) {
            return teacher;
        }
        else {
            return new Teacher(0L);
        }
    }

    private Boolean isTeacher () {
        Teacher teacher = getAuthenticatedTeacher();
        if (teacher.getTeacherId() == 0L) {
            return false;
        }
        else {
            return true;
        }
    }

    private Boolean isAdmin () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        String email = oauthUser.getEmail();
        User user = userService.getByEmail(email);
        if (user.getRole().getRoleId() == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Autowired
    public TeacherController(DepartmentService departmentService, DegreeService degreeService, DisciplineService disciplineService, SpecialityService specialityService, FacultyService facultyService, RoleService roleService, UserService userService, StudentService studentService, TeacherService teacherService, GradesService gradesService) {
        this.departmentService = departmentService;
        this.degreeService = degreeService;
        this.disciplineService = disciplineService;
        this.specialityService = specialityService;
        this.facultyService = facultyService;
        this.roleService = roleService;
        this.userService = userService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.gradesService = gradesService;
    }

    @GetMapping("head")
    public HttpEntity<String> getHeader () {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("test-header", Arrays.asList("test-header-value"));

        HttpEntity<String> responseEntity = new HttpEntity<>("test", headers);
        return responseEntity;
    }

    @RequestMapping(value="", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.HEAD, HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS)
                .build();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> defaultP () {
        if (isTeacher() || isAdmin()) {
            return ResponseEntity.ok("Welcome to teachers controller!");
        }
        else {
            return ResponseEntity.ok("You are not teacher, so you don't have access here!");
        }

    }

    @PostMapping(path = "grade",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Grades> gradeStudent (@RequestBody Grades grades) {
        if (isTeacher() || isAdmin()) {
            //Discipline discipline = teachersDiscipline();

            Grades grades1 = gradesService.getGrades(grades.getStudent().getStudentId(),grades.getDiscipline().getDiscipline_id());
            grades.setGradeId(grades1.getGradeId());
            gradesService.update(grades);
            return ResponseEntity.ok(grades);
        }
        else {
            return ResponseEntity.ok(new Grades());
        }
    }

    @GetMapping("studentGrades")
    public ResponseEntity<Grades> studentGrades(@RequestParam("idS") Long studentId,
                                                @RequestParam("idD") Long disciplineId) {
        if (isAdmin() || isTeacher()) {
            //Discipline discipline = teachersDiscipline();
            return ResponseEntity.ok(gradesService.getGrades(studentId,disciplineId));
        }
        else {
            return ResponseEntity.ok(new Grades());
        }
    }


    @GetMapping("getStudents")
    public ResponseEntity<List<Student>> getStudents (@RequestParam("id") Long disciplineId) {
        if (isAdmin() || isTeacher()) {
            //Discipline discipline = teachersDiscipline();
            return ResponseEntity.ok(disciplineService.getStudentsByD(disciplineId));
        }
        else {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

    private Discipline teachersDiscipline() {
        Discipline discipline = new Discipline();
        List<Discipline> disciplines = disciplineService.getDesciplineList();

        for (int i = 0; i < disciplines.size(); i++) {
            List<Teacher> teachers = disciplines.get(i).getTeacher();
            Optional<Teacher> optionalTeacher = teachers.stream().filter(t -> t.getTeacherId() == getAuthenticatedTeacher().getTeacherId()).findFirst();
            if (optionalTeacher.isPresent()) {
                discipline = disciplines.get(i);
            }
        }
        return discipline;
    }

//    @GetMapping("getGradesList")
//    public ResponseEntity<List<Grades>> getGradesList () {
//
//    }
}
