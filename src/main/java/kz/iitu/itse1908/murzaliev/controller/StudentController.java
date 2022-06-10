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

@Controller
@RequestMapping("student")
@Scope("prototype")
public class StudentController {

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

    private Student getAuthenticatedStudent () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        String email = oauthUser.getEmail();
        User user = userService.getByEmail(email);
        Student student = studentService.getByUser(user.getUserId());
        if (!(student.getStudentId() == null)) {
            return student;
        }
        else {
            return new Student(0L);
        }
    }

    private Boolean isStudent () {
        Student student = getAuthenticatedStudent();
        if (student.getStudentId() == 0L) {
            return false;
        }
        else {
            return true;
        }
    }

    @Autowired
    public StudentController(DepartmentService departmentService, DegreeService degreeService, DisciplineService disciplineService, SpecialityService specialityService, FacultyService facultyService, RoleService roleService, UserService userService, StudentService studentService, TeacherService teacherService, GradesService gradesService) {
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
        if (isStudent() || isAdmin()) {
            return ResponseEntity.ok("Welcome to teachers controller!");
        }
        else {
            return ResponseEntity.ok("You are not student, so you don't have access here!");
        }

    }

    @GetMapping("disciplines")
    public ResponseEntity<List<Discipline>> getDisciplines (@RequestParam("id") Long id) {
        if (isStudent() || isAdmin()) {
            return ResponseEntity.ok(disciplineService.getDByStudent(id));
        }
        else {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

    @GetMapping("gradesByD")
    public ResponseEntity<Grades> getGradesByD (@RequestParam("idD") Long idD, @RequestParam("idS") Long idS) {
        if (isStudent() || isAdmin()) {
            return ResponseEntity.ok(gradesService.getGrades(idS,idD));
        }
        else {
            return ResponseEntity.ok(new Grades());
        }
    }

    @GetMapping("getGpa")
    public Double getGPA (@RequestParam("id") Long studentId) {
        if (isStudent() || isAdmin()) {
            return studentService.getGPA(studentId);
        }
        else {
            return 0.0;
        }
    }
}
