package server.api.demo.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceIntegrationTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    void newWrite() {
        // given
        BoardRequest request = new BoardRequest();
        request.setUserName("Kang");
        request.setPw("1234");
        request.setSector("영화");
        request.setTitle("테스트입니다.");
        request.setComment("테스트입니다.!!");

        // when
        BoardEntity expected = boardService.newWrite(request);

        // then
        assertThat(expected.getUserName()).isEqualTo(request.getUserName());
    }

    @Test
    void searchOne() {
        BoardRequest request = new BoardRequest();

        request.setUserName("Kang");
        request.setPw("1234");
        request.setSector("영화");
        request.setTitle("테스트입니다.");
        request.setComment("테스트입니다.!!");

        BoardEntity expected = boardService.newWrite(request);
        Optional<BoardEntity> result = boardService.searchOne(expected.getBoardNum());

        //assertThat(result.getUserName()).isInstanceOf(NoSuchElementException.class);
        assertThat(result.isPresent()).isEqualTo(true);
    }

    @Test
    void searchAll() {
        BoardRequest request1 = new BoardRequest();
        BoardRequest request2 = new BoardRequest();

        boardService.newWrite(request1);
        boardService.newWrite(request2);

        List<BoardEntity> result = boardService.searchAll();

        assertEquals(2, result.size());
    }

    @Test
    void updateOne() {
        BoardRequest request1 = new BoardRequest();

        request1.setUserName("Kang");
        request1.setPw("1234");
        request1.setSector("영화");
        request1.setTitle("테스트입니다.");

        BoardEntity expected = boardService.newWrite(request1);
        String sector = expected.getSector();

        BoardRequest request2 = new BoardRequest();
        request2.setSector("드라마");

        BoardEntity result = boardService.updateOne(expected.getBoardNum(), request2);

        assertThat(result.getSector()).isNotEqualTo(sector);
    }

    @Test
    void deleteOne() {

        BoardRequest request = new BoardRequest();

        BoardEntity expected = boardService.newWrite(request);

        boardService.deleteOne(expected.getBoardNum());

        List<BoardEntity> list = boardService.searchAll();

        int result = list.size();

        assertEquals(0, result);
    }
}