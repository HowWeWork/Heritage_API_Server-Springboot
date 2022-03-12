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
    @Query(value = "select * from board order by like_count desc",nativeQuery = true)
    List<BoardEntity> findAllByLikeCountDesc();

    @Override
    @Query(value = "select * from board order by write_date desc",nativeQuery = true)
    List<BoardEntity> findAllByWriteDateDesc();
}
