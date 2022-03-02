package server.api.demo.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.LikeRequest;
import server.api.demo.repository.BoardRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SearchBestBoardTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void searchBestBoard() {

        BoardRequest request1 = new BoardRequest();
        BoardRequest request2 = new BoardRequest();
        BoardRequest request3 = new BoardRequest();
        BoardRequest request4 = new BoardRequest();

        request1.setUserName("1");
        request2.setUserName("2");
        request3.setUserName("3");
        request4.setUserName("4");

        BoardEntity expected1 = boardService.newWrite(request1);
        BoardEntity expected2 = boardService.newWrite(request2);
        BoardEntity expected3 = boardService.newWrite(request3);
        BoardEntity expected4 = boardService.newWrite(request4);

        LikeRequest like = new LikeRequest(true);

        boardService.updateOneLike(expected1.getBoardNum(),like);
        boardService.updateOneLike(expected1.getBoardNum(),like);
        boardService.updateOneLike(expected2.getBoardNum(),like);
        boardService.updateOneLike(expected3.getBoardNum(),like);
        boardService.updateOneLike(expected3.getBoardNum(),like);
        boardService.updateOneLike(expected3.getBoardNum(),like);
        boardService.updateOneLike(expected3.getBoardNum(),like);
        boardService.updateOneLike(expected3.getBoardNum(),like);
        boardService.updateOneLike(expected4.getBoardNum(),like);
        boardService.updateOneLike(expected4.getBoardNum(),like);
        boardService.updateOneLike(expected4.getBoardNum(),like);
        boardService.updateOneLike(expected4.getBoardNum(),like);

        List<BoardEntity> list = boardService.searchBestBoard();

        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

        Assertions.assertThat(list.get(0)).isEqualTo(expected3);
    }
}