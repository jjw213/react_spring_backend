package hello.hellospring.repository;

import hello.hellospring.controller.Board2Form;
import hello.hellospring.domain.Board2DTO;
import hello.hellospring.domain.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBoardRepository implements BoardRepository {

    private static Map<Integer, BoardDTO> store = new HashMap<>();
    private static Integer sequence = 0;

    @Override
    public BoardDTO save(BoardDTO boardDTO) {
        boardDTO.setIdx(++sequence);
        store.put(boardDTO.getIdx(), boardDTO);
        return boardDTO;
    }

    @Override
    public Optional<BoardDTO> findById(Integer idx) {
        return Optional.empty();
    }

    @Override
    public Optional<BoardDTO> findByName(String title) {
        return Optional.empty();
    }

    @Override
    public List<BoardDTO> show() {
        return null;
    }

    @Override
    public List<Board2DTO> show2(Board2Form form) {
        return null;
    }

    @Override
    public Board2DTO findByNo(Integer no) {
        return null;
    }


}
