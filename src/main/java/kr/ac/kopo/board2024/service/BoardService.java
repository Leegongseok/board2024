package kr.ac.kopo.board2024.service;

import kr.ac.kopo.board2024.dto.BoardDTO;
import kr.ac.kopo.board2024.entity.Board;
import kr.ac.kopo.board2024.entity.Member;

public interface BoardService {
    // 새글을 등록하는 기능
    Long register(BoardDTO dto);
// Entity를 DTO로 변환하는 메소드
    default BoardDTO entityToDTO(Board board, Member member,Long replyCount){
        BoardDTO boardDTO=BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regdate(board.getRegDate())
                .moddate(board.getModDate())
                .writerEmail(member.getEmail())
                .replyCount(replyCount.intValue())
                .build();

        return boardDTO;
    }

//  DTO를 Entity로 변환하는 메소드
    default Board dtoToEntity(BoardDTO dto){
        Member member=Member.builder()
                .email(dto.getWriterEmail())
                .build();

        Board board=Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

}
