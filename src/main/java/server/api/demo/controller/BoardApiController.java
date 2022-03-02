package server.api.demo.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.domain.BoardResponse;
import server.api.demo.domain.LikeRequest;
import server.api.demo.server.BoardService;

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

    // 선택 글 수정 요청
    @PatchMapping("/{boardNum}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long boardNum, @RequestBody BoardRequest request) {

        log.info("Update");

        BoardEntity selectOne = this.boardService.searchOne(boardNum).get();
        ResponseEntity<BoardResponse> ok;

        if ( selectOne.getPw().equals(request.getPw()) ) {

            BoardEntity result = this.boardService.updateOne(boardNum, request);

            ok = ResponseEntity.ok(new BoardResponse(result));

        } else {
            log.info("접근 권한 없음");

            ok = ResponseEntity.badRequest().build();
        }
        return ok;
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
