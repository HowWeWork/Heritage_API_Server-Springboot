package server.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import server.api.demo.repository.BoardRepository;
import server.api.demo.server.BoardService;
import server.api.demo.server.BoardServiceImpl;

@Configuration
public class AppConfig {

    private final BoardRepository boardRepository;

    @Autowired
    public AppConfig(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Bean
    public BoardService boardService() {
        return new BoardServiceImpl(boardRepository);
    }

}
