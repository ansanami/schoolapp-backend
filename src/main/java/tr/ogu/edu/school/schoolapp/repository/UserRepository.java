package tr.ogu.edu.school.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.ogu.edu.school.schoolapp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByMail(String mail);

	User findByTckn(String tckn);
}
