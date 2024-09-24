package kr.ac.kopo.board2024.service;

import kr.ac.kopo.board2024.dto.BoardDTO;
import kr.ac.kopo.board2024.dto.PageRequestDTO;
import kr.ac.kopo.board2024.dto.PageResultDTO;
import kr.ac.kopo.board2024.entity.Board;
import kr.ac.kopo.board2024.entity.Member;
import kr.ac.kopo.board2024.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        Function<Object[],BoardDTO> fn =(en ->entityToDTO((Board) en[0],(Member) en[1],(Long) en[2]));
        Page<Object[]> result =repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result,fn);
    }
}
