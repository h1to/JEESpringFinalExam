package kz.iitu.itse1908.murzaliev.controller;

import kz.iitu.itse1908.murzaliev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class MainController {

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

    @Autowired
    public MainController(DepartmentService departmentService, DegreeService degreeService, DisciplineService disciplineService, SpecialityService specialityService, FacultyService facultyService, RoleService roleService, UserService userService, StudentService studentService, TeacherService teacherService, GradesService gradesService) {
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
        return ResponseEntity.ok("Welcome to home page!");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
