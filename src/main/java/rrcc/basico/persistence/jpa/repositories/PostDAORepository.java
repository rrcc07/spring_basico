package rrcc.basico.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rrcc.basico.persistence.jpa.daos.PostDAO;

import java.util.List;
import java.util.Optional;

public interface PostDAORepository extends JpaRepository<PostDAO, Long> {
    /**QUERY METHOD*/
    List<PostDAO> findAllByUserId(long userId);
    Optional<PostDAO> findByUserIdAndId(long userId, long id);
}
