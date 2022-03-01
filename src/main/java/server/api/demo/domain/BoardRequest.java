package server.api.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardRequest {

    private String userName;

    private String pw;

    private String sector;

    private String title;

    private String comment;
}
