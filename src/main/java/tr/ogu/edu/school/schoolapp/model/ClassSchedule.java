package tr.ogu.edu.school.schoolapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_schedule")

public class ClassSchedule {

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