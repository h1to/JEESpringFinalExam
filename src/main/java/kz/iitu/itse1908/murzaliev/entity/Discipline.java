package kz.iitu.itse1908.murzaliev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Discipline {

    @Id
    @Column(name = "discipline_id", nullable = false, updatable = false)
    private Long discipline_id;

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "student_id")
    @ManyToMany
    @NonNull
    private List<Student> student;

    @NonNull
    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Teacher> teacher;

    public Discipline(Long discipline_id) {
        this.discipline_id = discipline_id;
    }

    public Discipline(Long discipline_id, String name) {
        this.discipline_id = discipline_id;
        this.name = name;
    }
}
