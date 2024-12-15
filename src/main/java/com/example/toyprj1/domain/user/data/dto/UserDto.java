package com.example.toyprj1.domain.user.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;  // 데이터베이스 테이블의 식별자Identification
    private String username;  // 아이디
    private String realname;  // 실명
    private String password;
    private String email;
}
