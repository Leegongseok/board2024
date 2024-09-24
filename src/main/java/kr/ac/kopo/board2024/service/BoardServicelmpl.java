package kr.ac.kopo.board2024.service;

import kr.ac.kopo.board2024.dto.BoardDTO;
import kr.ac.kopo.board2024.entity.Board;
import kr.ac.kopo.board2024.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BoardServicelmpl implements BoardService{
    private final BoardRepository repository;
    @Override
    public Long register(BoardDTO dto) {
        Board board =dtoToEntity(dto);
        repository.save(board);

        return board.getBno();
    }
}
