package kz.iitu.itse1908.murzaliev.controller;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.security.CustomOAuth2User;
import kz.iitu.itse1908.murzaliev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("admin")
public class AdminController {

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
    public AdminController(DepartmentService departmentService, DegreeService degreeService, DisciplineService disciplineService, SpecialityService specialityService, FacultyService facultyService, RoleService roleService, UserService userService, StudentService studentService, TeacherService teacherService, GradesService gradesService) {
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
        if (isAdmin()) {
            return ResponseEntity.ok("Welcome to admin controller!");
        }
        else {
            return ResponseEntity.ok("You are not admin, so you don't have access here!");
        }
    }

    @PostMapping("changeRole")
    public ResponseEntity<String> changeRole (@RequestParam("idU") Long userId, @RequestParam("idR") Long roleId) {
        if (isAdmin()) {
            User user = userService.getUserById(userId);
            user.setRole(new Role(roleId));
            userService.update(user);
            return ResponseEntity.ok("User role changed!");
        }
        else {
            return ResponseEntity.ok("Failed to update user with user_id=" + userId);
        }
    }

    @PostMapping("editUser")
    public ResponseEntity<String> editUser (@RequestBody User user) {
        if (isAdmin()) {
            userService.update(user);
            return ResponseEntity.ok("User updated!");
        }
        else {
            return ResponseEntity.ok("Failed to update user with user_id=" + user.getUserId());
        }
    }

    @PostMapping("editFaculty")
    public ResponseEntity<String> editFaculty (@RequestBody Faculty faculty) {
        if (isAdmin()) {
            facultyService.rename(faculty);
            return ResponseEntity.ok("Faculty renamed!");
        }
        else {
            return ResponseEntity.ok("Failed to rename faculty with faculty_id=" + faculty.getFacultyId());
        }
    }

    @PostMapping("editDegree")
    public ResponseEntity<String> editDegree (@RequestBody Degree degree) {
        if (isAdmin()) {
            degreeService.rename(degree);
            return ResponseEntity.ok("Degree renamed!");
        }
        else {
            return ResponseEntity.ok("Failed to rename degree with degree_id=" + degree.getDegreeId());
        }
    }

    @PostMapping("editDepartment")
    public ResponseEntity<String> editDepartment (@RequestBody Department department) {
        if (isAdmin()) {
            departmentService.rename(department);
            return ResponseEntity.ok("Department renamed!");
        }
        else {
            return ResponseEntity.ok("Failed to rename department with department_id=" + department.getDepartmentId());
        }
    }

    @PostMapping("editSpeciality")
    public ResponseEntity<String> editSpeciality (@RequestBody Speciality speciality) {
        if (isAdmin()) {
            specialityService.rename(speciality);
            return ResponseEntity.ok("Speciality renamed!");
        }
        else {
            return ResponseEntity.ok("Failed to rename speciality with speciality_id=" + speciality.getSpecialityId());
        }
    }
}
