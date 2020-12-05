package by.nagula.repository;

import by.nagula.entity.Chat;
import by.nagula.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByUserListId(long id);
}
