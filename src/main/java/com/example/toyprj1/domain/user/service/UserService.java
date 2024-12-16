package com.example.toyprj1.domain.user.service;

import com.example.toyprj1.domain.user.data.dto.UserDto;
import com.example.toyprj1.domain.user.data.entity.User;
import com.example.toyprj1.domain.user.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 리포지토리 기능들을 가져다 쓰는 "서비스의 메서드 정의"

    // CRUD about User domain

    // 생성
    // save
    public Long saveUser(
            String username,
            String realname,
            String password,
            String email

    ) {
        // builder 패턴을 이용하여 User 객체의 속성들에 파라미터값을 채워준다
        User emptyUserEntity = User.builder()
                .username(username)
                .realname(realname)
                .password(password)
                .email(email)
                .build();

        // 채워진 유저객체를 리포지토리 메서드를 이용해 저장한다
        User savedUserEntity = userRepository.save(emptyUserEntity);

        // 저장이 완료되면 저장된 유저객체의 id를 정의한다
        Long savedUserId = savedUserEntity.getId();

        // 정의된 "저장된 유저객체의 id"를 반환한다
        return savedUserId;
    }

    // 조회(id로)
    // get
    public UserDto getUserInfoById(Long userId) {
        // 리포지토리 메서드를 이용해 userId로 Optional 조회
        Optional<User> foundUserOptional = userRepository.findById(userId);

        // 옵셔널에서 User 엔티티 추출
        User extractedUserEntity = foundUserOptional.get();

        Long foundUserId = extractedUserEntity.getId();
        String foundUserUsername = extractedUserEntity.getUsername();
        String foundUserRealname = extractedUserEntity.getRealname();
        String foundUserEmail = extractedUserEntity.getEmail();

        // 비어있는 Dto 생성
        UserDto emptyUserDto = new UserDto();

        // 비어있는 Dto에 조회된 User Entity의 속성값을 가져다가 채워준다
        emptyUserDto.setId(foundUserId);
        emptyUserDto.setUsername(foundUserUsername);
        emptyUserDto.setRealname(foundUserRealname);
        emptyUserDto.setEmail(foundUserEmail);

        // 채워진 Dto를 반환한다
        return emptyUserDto;
    }

    // 조회(username으로)
    // get
    public UserDto getUserInfoByUsername(String username) {
        // 리포지토리 메서드를 이용해 username로 Optional 조회
        Optional<User> foundUserOptional = userRepository.findByUsername(username);

        // 옵셔널에서 User 엔티티 추출
        User extractedUserEntity = foundUserOptional.get();

        Long foundUserId = extractedUserEntity.getId();
        String foundUserUsername = extractedUserEntity.getUsername();
        String foundUserRealname = extractedUserEntity.getRealname();
        String foundUserEmail = extractedUserEntity.getEmail();

        // 비어있는 Dto 생성
        UserDto emptyUserDto = new UserDto();

        // 비어있는 Dto에 조회된 User Entity의 속성값을 가져다가 채워준다
        emptyUserDto.setId(foundUserId);
        emptyUserDto.setUsername(foundUserUsername);
        emptyUserDto.setRealname(foundUserRealname);
        emptyUserDto.setEmail(foundUserEmail);

        // 채워진 Dto를 반환한다
        return emptyUserDto;
    }

    // 조회(realname으로)
    // get
    public UserDto getUserInfoByRealname(String realname) {
        // 리포지토리 메서드를 이용해 realname로 Optional 조회
        Optional<User> foundUserOptional = userRepository.findByRealname(realname);

        // 옵셔널에서 User 엔티티 추출
        User extractedUserEntity = foundUserOptional.get();

        // 추출된 User entity의 각 속성을 각각 변수로 정의한다
        Long foundUserId = extractedUserEntity.getId();
        String foundUserUsername = extractedUserEntity.getUsername();
        String foundUserRealname = extractedUserEntity.getRealname();
        String foundUserEmail = extractedUserEntity.getEmail();

        // 비어있는 Dto 생성(왜냐면 이 메서드의 반환타입이 정해져있다. DTO로)
        UserDto emptyUserDto = new UserDto();

        // 비어있는 Dto에 조회된 User Entity의 속성값을 가져다가 채워준다
        emptyUserDto.setId(foundUserId);
        emptyUserDto.setUsername(foundUserUsername);
        emptyUserDto.setRealname(foundUserRealname);
        emptyUserDto.setEmail(foundUserEmail);

        // 채워진 Dto를 반환한다
        return emptyUserDto;
    }

    // 수정
    // change
    @Transactional
    public UserDto changeUserInfoExceptPasswordById(
            Long id,
            String username,
            String realname,
            String email
    ) {

        // 리포지토리 메서드로 id로 Optional 조회
        Optional<User> foundUserOptional = userRepository.findById(id);

        // Optional에서 User Entity를 꺼낸다
        User foundUserEntity = foundUserOptional.get();

        // 꺼낸 User entity를 수정한다
        User updatedUserEntity = foundUserEntity.update(id, username, realname, email);

        // 꺼내서 수정한 User entity를 리포지토리 메서드를 이용하여 저장한다
        User savedUserEntity = userRepository.save(updatedUserEntity);

        // 저장된 User entity의 각 속성을 각각 변수로 정의한다
        Long savedUserId = savedUserEntity.getId();
        String savedUserUsername = savedUserEntity.getUsername();
        String savedUserRealname = savedUserEntity.getRealname();
        String savedUserEmail = savedUserEntity.getEmail();

        // 비어있는 Dto 생성(왜냐면 이 메서드의 반환타입이 정해져있다. DTO로)
        UserDto emptyUserDto = new UserDto();

        // 비어있는 Dto에 저장된 User Entity의 속성값을 가져다가 채워준다
        emptyUserDto.setId(savedUserId);
        emptyUserDto.setUsername(savedUserUsername);
        emptyUserDto.setRealname(savedUserRealname);
        emptyUserDto.setEmail(savedUserEmail);

        // 채워진 Dto를 반환한다
        return emptyUserDto;
    }

    // 삭제
    // delete
    public void deleteUserById(Long userId) {
        // 리포지토리 메서드로 유저엔티티를 삭제한다
        userRepository.deleteById(userId);
    }



}
