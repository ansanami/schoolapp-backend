package tr.ogu.edu.school.schoolapp.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.ogu.edu.school.schoolapp.enums.AppointmentStatus;

@Entity
@Data
@Table(name = "appointments")
@NoArgsConstructor
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_seq")
    @SequenceGenerator(name = "appointment_id_seq", sequenceName = "appointment_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "teacher_id")
    private Long teacherId;

    private Date date;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
