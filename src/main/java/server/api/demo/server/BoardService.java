package server.api.demo.server;

import org.springframework.stereotype.Service;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.LikeRequest;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    BoardEntity newWrite(BoardRequest request);

    Optional<BoardEntity> searchOne(Long boardNum);

    List<BoardEntity> searchAll();

    BoardEntity updateOne(Long boardNum,BoardRequest request);

    BoardEntity updateOneLike(Long boardNum, LikeRequest likeRequest);

    void deleteOne(Long boardNum);
}
