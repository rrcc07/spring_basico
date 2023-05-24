package rrcc.basico.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rrcc.basico.persistence.jpa.daos.UserDAO;

public interface UserDAORepository extends JpaRepository<UserDAO, Long> {
}
