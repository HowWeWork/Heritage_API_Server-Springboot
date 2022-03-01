package server.api.demo.server;

import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    BoardEntity newWrite(BoardRequest request);

    Optional<BoardEntity> searchOne(Long boardNum);

    List<BoardEntity> searchAll();

    BoardEntity updateOne(Long boardNum,BoardRequest request);

    void deleteOne(Long boardNum);
}
