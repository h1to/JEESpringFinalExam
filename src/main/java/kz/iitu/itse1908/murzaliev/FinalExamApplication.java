package kz.iitu.itse1908.murzaliev;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import kz.iitu.itse1908.murzaliev.repository.repoImpl.DegreeRepoImpl;
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

    public static void main (String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Degree degree = new Degree(2L,"Masters's");
        degree.setName("No degree");

        System.out.println(degreeRepoImpl.findById(1L));
    }
}
