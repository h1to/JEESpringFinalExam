package kz.iitu.itse1908.murzaliev;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.*;
import kz.iitu.itse1908.murzaliev.security.MD5Hash;
import kz.iitu.itse1908.murzaliev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableAspectJAutoProxy
@SpringBootApplication
public class FinalExamApplication implements CommandLineRunner {

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
    UserRepoImpl userRepo;
    @Autowired
    public FinalExamApplication(DepartmentService departmentService, DegreeService degreeService, DisciplineService disciplineService, SpecialityService specialityService, FacultyService facultyService, RoleService roleService, UserService userService, StudentService studentService, TeacherService teacherService, GradesService gradesService) {
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

    public static void main (String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MD5Hash hash = new MD5Hash();

//        Department department = new Department("KAZ");
//        Department department1 = new Department("RU");
//        Department department2 = new Department("EN");
//        departmentService.addDepartment(department);
//        departmentService.addDepartment(department1);
//        departmentService.addDepartment(department2);
        List<Department> departmentList = departmentService.getDepartmentList();

        Role role = new Role(1L,"admin");
        Role role2 = new Role(2L,"default user");

//        User user = new User(role2, "user2@email.com", hash.getHash("user22"), false);
//        User user1 = new User(role2, "user3@email.com", hash.getHash("user23"), false);
//        User user2 = new User(role2, "user4@email.com", hash.getHash("user24"), false);
//        User user3 = new User(role2, "user5@email.com", hash.getHash("user25"), false);
//        User user4 = new User(role2, "user6@email.com", hash.getHash("user26"), false);
//        User user5 = new User(role2, "user7@email.com", hash.getHash("user27"), false);
//        User user6 = new User(role2, "user8@email.com", hash.getHash("user28"), false);
//        User user7 = new User(role2, "user9@email.com", hash.getHash("user29"), false);
//        User user8 = new User(role2, "user10@email.com", hash.getHash("user30"), false);
//        User user9 = new User(role2, "user11@email.com", hash.getHash("user33"), false);
//        User user10 = new User(role2, "user12@email.com", hash.getHash("user34"), false);
//        User user11 = new User(role2, "user13@email.com", hash.getHash("user31"), false);
//        User user12 = new User(role2, "user14@email.com", hash.getHash("user32"), false);
//        User user13 = new User(role2, "user15@email.com", hash.getHash("user35"), false);
//        userService.addUser(user);
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        userService.addUser(user4);
//        userService.addUser(user5);
//        userService.addUser(user6);
//        userService.addUser(user7);
//        userService.addUser(user8);
//        userService.addUser(user9);
//        userService.addUser(user10);
//        userService.addUser(user11);
//        userService.addUser(user12);
//        userService.addUser(user13);
        List<User> userList =  userService.getUserList();

        Degree bachelor = new Degree(4L,"Bachelor's");
        Degree master = new Degree(5L,"Master's");
        Degree doctor = new Degree(6L,"Doctor's");


//        Faculty faculty1 = new Faculty("IS");
//        Faculty faculty2 = new Faculty("JUR");
//        Faculty faculty3 = new Faculty("FIN");
//        Faculty faculty4 = new Faculty("MCM");
//        facultyService.addFaculty(faculty1);
//        facultyService.addFaculty(faculty2);
//        facultyService.addFaculty(faculty3);
//        facultyService.addFaculty(faculty4);
        List<Faculty> faculties = facultyService.getFacultyList();


//        Speciality speciality = new Speciality( "Big Data analytics",faculties.get(0));
//        Speciality speciality1 = new Speciality( "Business Journalism",faculties.get(1));
//        Speciality speciality2 = new Speciality( "E-Business",faculties.get(2));
//        Speciality speciality3 = new Speciality( "Computer science",faculties.get(3));
//        specialityService.addSpeciality(speciality);
//        specialityService.addSpeciality(speciality1);
//        specialityService.addSpeciality(speciality2);
//        specialityService.addSpeciality(speciality3);
        List<Speciality> specialities = specialityService.getSpecialityList();

//        Student student = new Student(userList.get(2), bachelor, departmentList.get(0), specialities.get(0), 2L, 3.5);
//        Student student1 = new Student(userList.get(3), master, departmentList.get(1), specialities.get(1), 1L, 3.0);
//        Student student2 = new Student(userList.get(4), doctor, departmentList.get(2), specialities.get(2), 1L, 3.3);
//        Student student3 = new Student(userList.get(5), bachelor, departmentList.get(0), specialities.get(3), 3L, 2.8);
//        Student student4 = new Student(userList.get(6), master, departmentList.get(1), specialities.get(4), 2L, 3.1);
//        Student student5 = new Student(userList.get(7), doctor, departmentList.get(2), specialities.get(0), 2L, 3.13);
//        Student student6 = new Student(userList.get(8), bachelor, departmentList.get(0), specialities.get(1), 4L, 3.45);
//        studentService.addStudent(student);
//        studentService.addStudent(student1);
//        studentService.addStudent(student2);
//        studentService.addStudent(student3);
//        studentService.addStudent(student4);
//        studentService.addStudent(student5);
//        studentService.addStudent(student6);
        List<Student> students = studentService.getStudentList();

//        Teacher teacher = new Teacher(userList.get(9), faculties.get(0), "Klim Klimov");
//        Teacher teacher1 = new Teacher(userList.get(10), faculties.get(1), "Ilya Rozinkin");
//        Teacher teacher2 = new Teacher(userList.get(11), faculties.get(2), "Ilyas Slyamov");
//        Teacher teacher3 = new Teacher(userList.get(12), faculties.get(3), "Aleksandr Filonenko");
//        Teacher teacher4 = new Teacher(userList.get(13), faculties.get(4), "Vladislav Khan");
//        Teacher teacher5 = new Teacher(userList.get(14), faculties.get(0), "Senjuro Kamado");
//        Teacher teacher6 = new Teacher(userList.get(15), faculties.get(1), "Zenitsu Flin");
//        teacherService.addTeacher(teacher);
//        teacherService.addTeacher(teacher1);
//        teacherService.addTeacher(teacher2);
//        teacherService.addTeacher(teacher3);
//        teacherService.addTeacher(teacher4);
//        teacherService.addTeacher(teacher5);
//        teacherService.addTeacher(teacher6);
        List<Teacher> teachers = teacherService.getTeacherList();

//        List<Teacher> teachersToAdd = new ArrayList<>();
//        List<Student> studentsToAdd = new ArrayList<>();
//        Discipline discipline =  new Discipline("Web Development", studentsToAdd, teachersToAdd);
//        Discipline discipline1 =  new Discipline("Business Components Development", studentsToAdd, teachersToAdd);
//        Discipline discipline2 =  new Discipline("Database Design", studentsToAdd, teachersToAdd);
//        disciplineService.addDescipline(discipline);
//        disciplineService.addDescipline(discipline1);
//        disciplineService.addDescipline(discipline2);
        List<Discipline> disciplines = disciplineService.getDesciplineList();

//        disciplineService.addStudents(students.subList(0,2),disciplines.get(0));
//        disciplineService.addStudents(students.subList(2,4),disciplines.get(1));
//        disciplineService.addStudents(students.subList(4,6),disciplines.get(2));
//        disciplineService.addTeachers(teachers.subList(0,2),disciplines.get(0));
//        disciplineService.addTeachers(teachers.subList(2,4),disciplines.get(1));
//        disciplineService.addTeachers(teachers.subList(4,6),disciplines.get(2));
    }
}
