package tr.ogu.edu.school.schoolapp.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "teachers")
public class Teachers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_id_seq")
    @SequenceGenerator(name = "teachers_id_seq", sequenceName = "teachers_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String surname;
}
