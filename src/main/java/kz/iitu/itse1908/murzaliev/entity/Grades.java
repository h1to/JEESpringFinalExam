package kz.iitu.itse1908.murzaliev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Grades {

    @Id
    @Column(name = "grade_id", nullable = false, insertable = false, updatable = false)
    private Long gradeId;

    @Column(name = "week_one")
    private Double week1;

    @Column(name = "week_two")
    private Double week2;

    @Column(name = "week_three")
    private Double week3;

    @Column(name = "week_four")
    private Double week4;

    @Column(name = "week_five")
    private Double week5;

    @Column(name = "week_six")
    private Double week6;

    @Column(name = "week_seven")
    private Double week7;

    @Column(name = "midterm")
    private Double midterm;

    @Column(name = "week_nine")
    private Double week9;

    @Column(name = "week_ten")
    private Double week10;

    @Column(name = "week_eleven")
    private Double week11;

    @Column(name = "week_twelv")
    private Double week12;

    @Column(name = "week_therteen")
    private Double week13;

    @Column(name = "week_fourteen")
    private Double week14;

    @Column(name = "endterm")
    private Double endterm;

    @Column(name = "exam")
    private Double exam;

    @Column(name = "final_grade")
    private Double finalGrade;
}
