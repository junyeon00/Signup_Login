package spring_practice.web_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_practice.web_practice.dto.UserRequestDto;
import spring_practice.web_practice.dto.UserResponseDto;
import spring_practice.web_practice.entity.User;
import spring_practice.web_practice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public UserResponseDto userRegister(UserRequestDto userRequestDto) {
        // 요청 객체 -> Entity
        User user = new User(userRequestDto);

        // DB 저장
        userRepository.save(user);

        // Entity -> 반환 객체
        return new UserResponseDto(user);
    }

    // 회원가입 여부 확인
    public boolean userLogin(UserRequestDto userRequestDto) {
        return userRepository.existsById(userRequestDto.getId());
    }

    // 회원 정보 수정
    @Transactional
    public void updateUser(String id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        user.update(userRequestDto);
        userRepository.save(user);
    }

    // 사용자 정보 가져오기
    public UserResponseDto getUserInfo(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));
        return new UserResponseDto(user);
    }
}
