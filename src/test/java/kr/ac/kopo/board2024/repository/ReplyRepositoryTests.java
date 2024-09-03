package kr.ac.kopo.board2024.repository;

import kr.ac.kopo.board2024.entity.Board;
import kr.ac.kopo.board2024.entity.Member;
import kr.ac.kopo.board2024.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;
    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i->{
           long bno = (long)(Math.random()*100 +1); //1~100 임의의 long 형의 정수값

            Board board =Board.builder()
                    .bno(bno)
                    .build();
            Reply reply =Reply.builder()
                    .text("Reply" +i)
                    .board(board)
                    .replyer("guest")
                    .build();
            replyRepository.save(reply);

        });
    }
}
