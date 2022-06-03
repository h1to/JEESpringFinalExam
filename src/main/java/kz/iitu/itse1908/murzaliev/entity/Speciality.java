package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Speciality {

    @Id
    @Column(name = "speciality_id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Speciality(String name, @NonNull Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    @Autowired
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
