package server.api.demo.server;

import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    /**
     * 글쓰기
     * @param request : 클라이언트가 글 생성을 위해 기입한 정보
     * @return
     */
    @Override
    public BoardEntity newWrite(BoardRequest request) {

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setUserName(request.getUserName());
        boardEntity.setPw(request.getPw());
        boardEntity.setSector(request.getSector());
        boardEntity.setTitle(request.getTitle());
        boardEntity.setComment(request.getComment());

        return repository.save(boardEntity);
    }

    /**
     * 선택 글 조회
     * @param boardNum : 해당 게시글 번호
     * @return
     */
    @Override
    public Optional<BoardEntity> searchOne(Long boardNum) {
        return repository.findById(boardNum);
    }

    /**
     * 전체 글 조회
     */
    @Override
    public List<BoardEntity> searchAll() {
        return this.repository.findAll();
    }

    /**
     * 선택 글 수정
     * @param boardNum : 해당 게시글 번호
     * @param request : 클라이언트가 변경하는 내용
     * @return
     */
    @Override
    public BoardEntity updateOne(Long boardNum, BoardRequest request) {
        BoardEntity board = this.searchOne(boardNum).get();

        if (request.getSector() != null)
            board.setSector(request.getSector());
        if (request.getTitle() != null)
            board.setTitle(request.getTitle());
        if (request.getComment() != null)
            board.setComment(request.getComment());

        return repository.update(board);
    }

    /**
     * 선택 글 삭제
     * @param boardNum : 해당 게시글 번호
     */
    @Override
    public void deleteOne(Long boardNum) {
        repository.deleteById(boardNum);
    }

}
