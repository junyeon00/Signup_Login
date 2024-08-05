package spring_practice.web_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_practice.web_practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
