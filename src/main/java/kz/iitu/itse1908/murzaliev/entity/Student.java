package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@DependsOn("user")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    private Long studentId;

    @NonNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @OneToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @NonNull
    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    @NonNull
    @JoinColumn(name = "speciality_id")
    @ManyToOne
    private Speciality speciality;

    @NonNull
    @Column(name = "year")
    private Long year;

    @NonNull
    @Column(name = "gpa")
    private Double gpa;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    public void setDegree(Degree student) {
        this.degree = student;
    }

    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Autowired
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Student(Long studentId) {
        this.studentId = studentId;
    }

    public Student(@NonNull User user, @NonNull Degree degree, @NonNull Department department, @NonNull Speciality speciality, @NonNull Long year, @NonNull Double gpa) {
        this.user = user;
        this.degree = degree;
        this.department = department;
        this.speciality = speciality;
        this.year = year;
        this.gpa = gpa;
    }
}
