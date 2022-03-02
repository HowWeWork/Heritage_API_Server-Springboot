package server.api.demo.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.LikeRequest;
import server.api.demo.repository.BoardRepository;
import server.api.demo.repository.SpringDataJpaRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LikeFunctionTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    void updateOneLike() {

        //given
        BoardRequest createRequest = new BoardRequest();
        LikeRequest request = new LikeRequest();

        //when
        createRequest.setUserName("kang");
        BoardEntity newBoard = boardService.newWrite(createRequest);

        request.setLike(true);

        int expected = newBoard.getLikeCount() + 1;

        BoardEntity result = boardService.updateOneLike(newBoard.getBoardNum(), request);

        //then
        Assertions.assertThat(result.getLikeCount()).isEqualTo(expected);
    }

    @Test
    void unLike() {
        //given
        BoardRequest createRequest = new BoardRequest();
        LikeRequest request1 = new LikeRequest();
        LikeRequest request2 = new LikeRequest();

        //when
        createRequest.setUserName("kang");

        BoardEntity newBoard = boardService.newWrite(createRequest);

        request1.setLike(true);
        BoardEntity expected = boardService.updateOneLike(newBoard.getBoardNum(), request1);
        int i = expected.getLikeCount();
        System.out.println("expected : " + i);

        request2.setLike(false);
        BoardEntity result = boardService.updateOneLike(newBoard.getBoardNum(), request2);
        int j = result.getLikeCount();
        System.out.println("result : " + j);
        //then
        Assertions.assertThat(j).isEqualTo(i-1);
    }
}