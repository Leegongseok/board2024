package kr.ac.kopo.board2024.repository;

import kr.ac.kopo.board2024.entity.Board;
import kr.ac.kopo.board2024.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
