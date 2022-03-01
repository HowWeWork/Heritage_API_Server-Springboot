package server.api.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.api.demo.repository.BoardRepository;
import server.api.demo.repository.MemoryBoardRepository;
import server.api.demo.server.BoardService;
import server.api.demo.server.BoardServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public BoardService boardService() {
        return new BoardServiceImpl(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new MemoryBoardRepository();
    }
}
