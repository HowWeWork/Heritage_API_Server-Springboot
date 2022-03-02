package server.api.demo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.BoardResponse;
import server.api.demo.domain.LikeRequest;
import server.api.demo.server.BoardService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jayway.jsonpath.internal.Utils.isEmpty;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardApiController {

    private final BoardService boardService;

    // 글 쓰기 요청
    @PostMapping
    public ResponseEntity<BoardResponse> create(@RequestBody BoardRequest request) {

        log.info("Create");

        if(isEmpty(request.getUserName())
                || isEmpty(request.getPw())
                || isEmpty(request.getSector())
                || isEmpty(request.getTitle())
                || isEmpty(request.getComment())) {

            return ResponseEntity.badRequest().build();
        }

        BoardEntity newBoard = this.boardService.newWrite(request);
        return ResponseEntity.ok(new BoardResponse(newBoard));
    }

    // 암호를 통한 글 조회 및 수정, 삭제 접근
    @GetMapping("/{boardNum}/check")
    public ResponseEntity<BoardResponse> checkPassword(@PathVariable Long boardNum, @RequestBody BoardRequest request) {

        log.info("checkPw " + boardNum);
        BoardEntity board = boardService.searchOne(boardNum).get();
        ResponseEntity<BoardResponse> result;

        if ( board.getPw().equals(request.getPw()) ) {

            result = ResponseEntity.ok(new BoardResponse(board));

        } else {

            log.info("잘못된 비밀번호입니다.");

            result = ResponseEntity.badRequest().build();

        }

        return result;
    }

    // 단일 글 조회 요청
    @GetMapping("/{boardNum}")
    public ResponseEntity<BoardResponse> readOne(@PathVariable Long boardNum) {

        log.info("Read One " + boardNum);

        Optional<BoardEntity> result = this.boardService.searchOne(boardNum);
        return ResponseEntity.ok(new BoardResponse(result.get()));
    }

    // 전체 글 조회 요청
    @GetMapping
    public ResponseEntity<List<BoardResponse>> readAll() {

        List<BoardEntity> list = this.boardService.searchAll();

        log.info("Read All (" + list.size() + ")");

        List<BoardResponse> response = list.stream().map(BoardResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // Top 3 게시글 조회 기능
    @GetMapping("/best")
    public ResponseEntity<List<BoardResponse>> readBestBoard() {

        List<BoardEntity> list = this.boardService.searchBestBoard();
        List<BoardResponse> response = list.stream().map(BoardResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // 선택 글 수정 요청
    @PatchMapping("/{boardNum}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long boardNum, @RequestBody BoardRequest request) {

        log.info("Update");

        BoardEntity result = this.boardService.updateOne(boardNum, request);

        return ResponseEntity.ok(new BoardResponse(result));
    }

    // 선택 글 좋아요 상태 및 수 체크
    @PatchMapping("/{boardNum}/like")
    public ResponseEntity<BoardResponse> likeUpdate(@PathVariable Long boardNum, @RequestBody LikeRequest request) {

        log.info("Like button click");

        BoardEntity result = this.boardService.updateOneLike(boardNum, request);

        return ResponseEntity.ok(new BoardResponse(result));
    }

    // 선택 글 삭제 요청
    @DeleteMapping("/{boardNum}")
    public ResponseEntity<?> deleteOne(@PathVariable Long boardNum) {
        log.info("Delete One " + boardNum );
        this.boardService.deleteOne(boardNum);
        return ResponseEntity.ok().build();
    }
}
