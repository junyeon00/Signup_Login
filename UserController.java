package spring_practice.web_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_practice.web_practice.dto.UserRequestDto;
import spring_practice.web_practice.dto.UserResponseDto;
import spring_practice.web_practice.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody UserRequestDto userRequestDto) {
        return userService.userRegister(userRequestDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto userRequestDto) {
        if (userService.userLogin(userRequestDto)) {
            return userRequestDto.getId();
        } else {
            throw new IllegalArgumentException("존재하지 않는 아이디이거나 비밀번호가 틀렸습니다.");
        }
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return id;
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUserInfo(@PathVariable String id) {
        return userService.getUserInfo(id);
    }
}
