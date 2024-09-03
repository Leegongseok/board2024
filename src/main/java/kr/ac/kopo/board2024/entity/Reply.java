package kr.ac.kopo.board2024.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동으로 1씩 증가
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    private Board board; //Foreign key 설정(참조무결성 유지)
}
