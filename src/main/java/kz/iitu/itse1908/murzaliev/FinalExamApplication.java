package kz.iitu.itse1908.murzaliev;

import kz.iitu.itse1908.murzaliev.entity.*;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.*;
import kz.iitu.itse1908.murzaliev.security.MD5Hash;
import kz.iitu.itse1908.murzaliev.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FinalExamApplication implements CommandLineRunner {

    @Autowired
    DegreeRepoImpl degreeRepoImpl;

    @Autowired
    DegreeService degreeService;

    @Autowired
    SpecialityRepoImpl specialityRepo;

    @Autowired
    FacultyRepoImpl facultyRepo;

    @Autowired
    RoleRepoImpl roleRepo;

    @Autowired
    UserRepoImpl userRepo;
    public static void main (String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MD5Hash hash = new MD5Hash();

        Faculty faculty = new Faculty(1L,"CSSE");
        //facultyRepo.save(faculty);

        Speciality speciality = new Speciality(1L, "Software Engineering",faculty);
        //specialityRepo.save(speciality);

        Role role = new Role(2L,"admin");
        //roleRepo.save(role);

        User user = new User(role, "teacher@gmail.com", hash.getHash("teach2022"), false);
        //userRepo.save(user);

        Degree degree = new Degree("Bachelor's");
        Degree degree1 = new Degree("Master's");
        //degreeRepoImpl.save(degree);
        //degreeRepoImpl.save(degree1);

        System.out.println(degreeService.getDegreeList());



        //System.out.println(userRepo.findAll());
    }
}
