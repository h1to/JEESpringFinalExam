package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Teacher {

    @Id
    @Column(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    @OneToOne
    @NonNull
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @OneToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    public Teacher(@NonNull User user, @NonNull Faculty faculty, @NonNull String name) {
        this.user = user;
        this.faculty = faculty;
        this.name = name;
    }

    @Autowired
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
