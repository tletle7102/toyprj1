package com.example.toyprj1.domain.user.data.repository;

import com.example.toyprj1.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 데이터베이스와 상호작용을 담당하는 기능
public interface UserRepository extends JpaRepository<User, Long> {

    // 사용자에 대한 기능(데이터베이스의 관점)
    // 생성save(jpaRepository의 save메서드를 사용)

    // 조회
    Optional<User> findById(Long id);  // id로 User객체를 담고 있는 optional 타입 반환하는 기능
    Optional<User> findByUsername(String username);  // username로 User객체를 담고 있는 optional 타입 반환하는 기능
    Optional<User> findByRealname(String realname);  // realname로 User객체를 담고 있는 optional 타입 반환하는 기능

    // 수정
    // 따로 메서드가 정의될 필요가 없음. 왜냐면 수정이라는 기능의 내부동작은 조회 후 저장이기 때문

    // 삭제
    void deleteById(Long id);  // id로 User객체를 삭제하는 기능

}
