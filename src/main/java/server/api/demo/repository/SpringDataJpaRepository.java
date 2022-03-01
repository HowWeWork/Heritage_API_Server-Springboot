package server.api.demo.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.api.demo.domain.BoardEntity;

public interface SpringDataJpaRepository extends JpaRepository<BoardEntity,Long>,BoardRepository {

}
