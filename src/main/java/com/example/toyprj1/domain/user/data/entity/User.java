package com.example.toyprj1.domain.user.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
//@Setter  주석처리의 이유는 보안문제: 엔티티에 Setter 사용제한
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 데이터베이스 테이블의 식별자Identification
    @Column(nullable = false, unique = true)
    private String username;  // 사용자명
    @Column(nullable = false)
    private String realname;  // 실명
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    public User update(
            Long id,
            String username,
            String realname,
            String email
    ) {
        User user = User.builder()
                .id(id)
                .username(username)
                .realname(realname)
                .password(this.password)
                .email(email)
                .build();

        return user;
    }

}