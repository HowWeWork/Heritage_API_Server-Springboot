package server.api.demo.repository;

import server.api.demo.domain.BoardEntity;

import java.util.*;

public class MemoryBoardRepository implements BoardRepository {

    private static Map<Long, BoardEntity> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public BoardEntity save(BoardEntity board) {
        board.setBoardNum(++sequence);
        store.put(board.getBoardNum(), board);
        return board;
    }

    @Override
    public Optional<BoardEntity> findById(Long boardNum) {
        return Optional.ofNullable(store.get(boardNum));
    }

    @Override
    public List<BoardEntity> findAll() {
        return new ArrayList<>(store.values());
    }


    public BoardEntity update(BoardEntity board) {
        board.setBoardNum(sequence);
        store.put(board.getBoardNum(), board);
        return board;
    }

    @Override
    public void deleteById(Long boardNum) {
        store.remove(boardNum);
    }

    public void clearStore() {
        store.clear();
    }
}
