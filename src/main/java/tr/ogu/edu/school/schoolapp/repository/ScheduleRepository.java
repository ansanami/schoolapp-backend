package tr.ogu.edu.school.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.ogu.edu.school.schoolapp.model.Schedule;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
