package server.api.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.spi.LocaleNameProvider;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardResponse {

    /**
     * 클라이언트에게 응답으로 넘겨줄 데이터 entity
     */

    private Long boardNum;
    private String userName;
    private String pw;
    private String sector;
    private String title;
    private String comment;
    private Integer likeCount;
    private LocalDateTime writeDate;

    public BoardResponse(BoardEntity board) {

        log.info(board.toString());

        this.boardNum = board.getBoardNum();
        this.userName = board.getUserName();
        this.pw = board.getPw();
        this.sector = board.getSector();
        this.title = board.getTitle();
        this.comment = board.getComment();
        this.likeCount = board.getLikeCount();
        this.writeDate = board.getWriteDate();
    }
}
