package spring_practice.web_practice.dto;

import lombok.Getter;
import spring_practice.web_practice.entity.User;

import java.time.LocalDate;

@Getter
public class UserResponseDto {
    private String id;
    private String pw;
    private String name;
    private LocalDate birthdate;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.pw = user.getPw();
        this.name = user.getName();
        this.birthdate = user.getBirthdate();
        this.email = user.getEmail();
    }
}