package tr.ogu.edu.school.schoolapp.model;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "period1")
    private String period1;

    @Column(name = "period2")
    private String period2;

    @Column(name = "period3")
    private String period3;

    @Column(name = "period4")
    private String period4;

    @Column(name = "period5")
    private String period5;

    @Column(name = "period6")
    private String period6;
}
