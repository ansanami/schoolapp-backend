package tr.ogu.edu.school.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.ogu.edu.school.schoolapp.model.ActTicket;

import java.util.List;

@Repository
public interface ActTicketRepository extends JpaRepository<ActTicket, Long> {
	ActTicket findByVerificationCode(String verificationCode);

	List<ActTicket> findAllByUserId(Long userId);
}