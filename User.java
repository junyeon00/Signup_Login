package spring_practice.web_practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_practice.web_practice.dto.UserRequestDto;

import java.time.LocalDate;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "User") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class User{
    @Id
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "pw", nullable = false, length = 8)
    private String pw;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public User(UserRequestDto userRequestDto) {
        this.id = userRequestDto.getId();
        this.pw = userRequestDto.getPw();
        this.name = userRequestDto.getName();
        this.birthdate = userRequestDto.getBirthdate();
        this.email = userRequestDto.getEmail();
    }

    public void update(UserRequestDto userRequestDto) {
        this.id = userRequestDto.getId();
        this.pw = userRequestDto.getPw();
        this.name = userRequestDto.getName();
        this.birthdate = userRequestDto.getBirthdate();
        this.email = userRequestDto.getEmail();
    }
}
