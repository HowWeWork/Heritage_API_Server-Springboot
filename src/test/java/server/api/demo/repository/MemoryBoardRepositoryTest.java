package server.api.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import server.api.demo.domain.BoardEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemoryBoardRepositoryTest {

    MemoryBoardRepository repository = new MemoryBoardRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given
        BoardEntity board = new BoardEntity();
        board.setUserName("kang");

        //when
        BoardEntity newBoard = repository.save(board);
        BoardEntity result = repository.findById(newBoard.getBoardNum()).get();

        //then
        System.out.println(result.getBoardNum());

        assertThat(board).isEqualTo(result);
    }

    @Test
    void findById() {

        //given
        BoardEntity board1 = new BoardEntity();
        board1.setUserName("kang");
        board1.setPw("1234");
        board1.setSector("영화");
        board1.setTitle("테스트입니다.");
        board1.setComment("테스트입니다...");

        //when
        BoardEntity actual = repository.save(board1);
        BoardEntity result = repository.findById(actual.getBoardNum()).get();
        //then
        assertThat(actual).isEqualTo(result);

    }

    @Test
    void findAll() {

        BoardEntity board1 = new BoardEntity();
        board1.setUserName("kang");
        board1.setPw("1234");
        board1.setSector("영화");
        board1.setTitle("테스트입니다.");
        board1.setComment("테스트입니다...");

        BoardEntity board2 = new BoardEntity();
        board2.setUserName("soo");
        board2.setPw("1234");
        board2.setSector("독서");
        board2.setTitle("테스트입니다2");
        board2.setComment("테스트입니다2...");

        repository.save(board1);
        repository.save(board2);

        List<BoardEntity> result = repository.findAll();
        int size = result.size();

        assertThat(size).isEqualTo(2);
    }

    @Test
    void update() {
        BoardEntity board = new BoardEntity();
        board.setUserName("kang");

        //when
        BoardEntity newBoard = repository.save(board);

        BoardEntity board2 = new BoardEntity();
        board2.setUserName("soo");

        //then
        BoardEntity updateBoard = repository.update(board2);

        assertThat(updateBoard.getUserName()).isNotEqualTo(newBoard.getUserName());
        assertThat(updateBoard.getBoardNum()).isEqualTo(newBoard.getBoardNum());
    }

    @Test
    void deleteById() {
        BoardEntity board1 = new BoardEntity();
        board1.setUserName("kang");
        board1.setPw("1234");
        board1.setSector("영화");
        board1.setTitle("테스트입니다.");
        board1.setComment("테스트입니다...");

        BoardEntity board2 = new BoardEntity();
        board2.setUserName("soo");
        board2.setPw("1234");
        board2.setSector("독서");
        board2.setTitle("테스트입니다2");
        board2.setComment("테스트입니다2...");

        BoardEntity newBoard1 = repository.save(board1);
        BoardEntity newBoard2 = repository.save(board2);

        repository.deleteById(newBoard1.getBoardNum());
        List<BoardEntity> result = repository.findAll();
        BoardEntity expected = result.get(0);
        BoardEntity actual = repository.findById(newBoard2.getBoardNum()).get();
        assertThat(expected).isEqualTo(actual);
    }
}