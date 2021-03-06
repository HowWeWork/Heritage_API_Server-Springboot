package server.api.demo.repository;

import server.api.demo.domain.BoardEntity;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    BoardEntity save(BoardEntity board);

    Optional<BoardEntity> findById(Long boardNum);

    List<BoardEntity> findAll();

    List<BoardEntity> findAllByWriteDateDesc();

    List<BoardEntity> findAllByLikeCountDesc();

    void deleteById(Long boardNum);
}
