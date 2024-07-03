package tr.ogu.edu.school.schoolapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import tr.ogu.edu.school.schoolapp.enums.SeatStatus;
import tr.ogu.edu.school.schoolapp.model.ActSessionHallSeat;
import tr.ogu.edu.school.schoolapp.model.User;

@Repository
public interface ActSessionHallSeatRepository extends JpaRepository<ActSessionHallSeat, Long> {

	List<ActSessionHallSeat> findAllByActSessionInfoId(Long sessionId);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<ActSessionHallSeat> findAllByStatusAndIdGreaterThanOrderByIdAsc(SeatStatus status, Long id, Pageable pageable);

	@Query("SELECT s FROM ActSessionHallSeat s WHERE s.actSeat.id = :actSeatId")
	ActSessionHallSeat findAllByActSeatId(Long actSeatId);

	@Query("SELECT s FROM ActSessionHallSeat s WHERE s.user.id = :user AND s.status = 'BLOCKED'")
	List<ActSessionHallSeat> findAllByUser(Long user);


}