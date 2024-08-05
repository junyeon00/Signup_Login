package spring_practice.web_practice.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserRequestDto {
    private String id;
    private String pw;
    private String name;
    private LocalDate birthdate;
    private String email;
}
