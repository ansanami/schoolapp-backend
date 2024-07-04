package tr.ogu.edu.school.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tr.ogu.edu.school.schoolapp.model.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserId(Long userId);
    @Query("SELECT s FROM Appointment s WHERE s.teacherId = :teacherId")
    List<Appointment> findByTeacherId(Long teacherId);

}
