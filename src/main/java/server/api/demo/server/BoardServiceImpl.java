package server.api.demo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.LikeRequest;
import server.api.demo.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    /**
     * 글쓰기
     * @param request : 클라이언트가 글 생성을 위해 기입한 정보
     * @return
     */
    @Override
    @Transactional
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
        return this.repository.findAllByWriteDateDesc();
    }

    /**
     * Top 3 게시글 조회 기능
     * @return 좋아요 수 베스트 1~3위 리스트
     */
    @Override
    public List<BoardEntity> searchBestBoard() {
        List<BoardEntity> sortedList = this.repository.findAllByLikeCountDesc();
        List<BoardEntity> BestList = new ArrayList<>();

        for(int i=0; i<sortedList.size();i++) {

            if(i>2){
                break;
            } else {
                BestList.add(sortedList.get(i));
            }
        }

        return BestList;
    }

    /**
     * 선택 글 수정
     * @param boardNum : 해당 게시글 번호
     * @param request : 클라이언트가 변경하는 내용
     * @return
     */
    @Override
    @Transactional
    public BoardEntity updateOne(Long boardNum, BoardRequest request) {
        BoardEntity board = this.searchOne(boardNum).get();

        if (request.getSector() != null)
            board.setSector(request.getSector());
        if (request.getTitle() != null)
            board.setTitle(request.getTitle());
        if (request.getComment() != null)
            board.setComment(request.getComment());

        return repository.save(board);
    }

    /**
     * 선택 글의 '좋아요' 버튼 클릭 후 좋아요 수 증가
     */
    @Override
    @Transactional
    public BoardEntity updateOneLike(Long boardNum, LikeRequest likeRequest) {

        BoardEntity board = this.searchOne(boardNum).get();

        if(likeRequest.isLike() == true)
            board.setLikeCount(board.getLikeCount() + 1);
        else if(likeRequest.isLike() == false ){
            board.setLikeCount(board.getLikeCount() - 1);
        } else {
            System.out.println("boardService-updateOneLike : 잘못된 값입니다.");
        }

        return repository.save(board);
    }

    /**
     * 선택 글 삭제
     * @param boardNum : 해당 게시글 번호
     */
    @Override
    @Transactional
    public void deleteOne(Long boardNum) {
        repository.deleteById(boardNum);
    }

}
