package com.example.toyprj1.domain.board.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
//@Setter  주석처리의 이유는 보안문제: 엔티티에 Setter 사용제한
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_board")
public class Board {

    //id랑 제목, 내용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;  // 작성자
    @Column(nullable = false)
    private String boardTitle;  // 제목
    @Column(nullable = false)
    private String boardContent;  // 내용
    @Column(nullable = false)
    private LocalDateTime createdDttm; //작성시간
    @Column(nullable = false)
    private LocalDateTime updatedDttm; //수정시간


    public Board update(
            String boardTitle,
            String boardContent
    ) {
        Board board = Board.builder()
                .id(this.id)
                .username(this.username)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .createdDttm(this.createdDttm)
                .updatedDttm(LocalDateTime.now())
                .build();

        return board;


    }


}
