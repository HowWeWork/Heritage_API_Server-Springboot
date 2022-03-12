package server.api.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "BOARD")
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum;

    private String userName;

    private String pw;

    private String sector;

    private String title;

    private String comment;

    private Integer likeCount = 0;

    // 글 작성 시간
    private LocalDateTime writeDate;

    @PrePersist
    public void writeDate() {
        this.writeDate = LocalDateTime.now();
    }

}
