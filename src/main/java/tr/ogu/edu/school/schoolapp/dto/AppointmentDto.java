package tr.ogu.edu.school.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentDto {
    private Long id;
    private Long userId;
    private Long teacherId;
    private Date date;
    private String status;
}
