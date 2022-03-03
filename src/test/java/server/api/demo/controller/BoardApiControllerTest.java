package server.api.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import server.api.demo.domain.BoardEntity;
import server.api.demo.domain.BoardRequest;
import server.api.demo.server.BoardService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoardApiController.class)
public class BoardApiControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BoardService boardService;

    private BoardEntity expected;

    @BeforeEach
    void setup() {
        this.expected = new BoardEntity();
        this.expected.setBoardNum(1L);
        this.expected.setUserName("ANY NAME");
        this.expected.setPw("1111");
        this.expected.setSector("TEST SECTOR");
        this.expected.setTitle("TEST TITLE");
        this.expected.setComment("TEST COMMENT");
        this.expected.setLikeCount(0);
    }

    @Test
    void create() throws Exception {
        when(this.boardService.newWrite(any(BoardRequest.class)))
                .then((i)->{
                    BoardRequest request = i.getArgument(0, BoardRequest.class);
                    return new BoardEntity(this.expected.getBoardNum(),
                                            this.expected.getUserName(),
                                            this.expected.getPw(),
                                            this.expected.getSector(),
                                            this.expected.getTitle(),
                                            this.expected.getComment(),
                                            this.expected.getLikeCount());
                });

        BoardRequest request = new BoardRequest();
        request.setUserName("ANY NAME");

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);

        this.mvc.perform(post("/board")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("Any NAME"));

    }
}
