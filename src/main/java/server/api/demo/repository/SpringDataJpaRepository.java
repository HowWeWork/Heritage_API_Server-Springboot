package server.api.demo.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.api.demo.domain.BoardEntity;

import java.util.List;

@Repository
public interface SpringDataJpaRepository extends JpaRepository<BoardEntity,Long>,BoardRepository {

    @Override
    @Query(value = "select * from BOARD order by BOARD.LIKE_COUNT desc",nativeQuery = true)
    List<BoardEntity> findAllByLikeCountDesc();

}
