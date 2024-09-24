package kr.ac.kopo.board2024.service;


import kr.ac.kopo.board2024.dto.BoardDTO;
import kr.ac.kopo.board2024.dto.PageRequestDTO;
import kr.ac.kopo.board2024.dto.PageResultDTO;
import kr.ac.kopo.board2024.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto=BoardDTO.builder()
                .title("Board Test...101")
                .content("101 Board Test Board Test Board Test")
                .writerEmail("user7@kopo.ac.kr")
                .build();
        Long bno= boardService.register(dto);
        System.out.println("정상적으로 글이 저장되었습니다. :"+bno);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO =new PageRequestDTO();

        PageResultDTO<BoardDTO,Object[]> result=boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);

        }
    }
    @Test void testGet(){
        Long bno=2L;

        BoardDTO boardDTO =boardService.get(bno);

        System.out.println(boardDTO);
    }
    @Test
    void testRemove(){
        Long bno=1L;
        boardService.removeWithReplies(bno);

    }
    @Test
    public void testModify(){
        BoardDTO boardDTO=BoardDTO.builder()
                .bno(2L)
                .title("수정된 제목 연습")
                .content("수정한 내용 연습")
                .build();
        boardService.modify(boardDTO);
    }
}


