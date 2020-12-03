package by.nagula.service;

import by.nagula.dto.ChatDto;
import by.nagula.entity.Chat;

import java.util.List;

public interface ChatService {
    void createChat(Chat chat);
    void removeChat(long id);
    List<Chat> showAllChats();
    Chat showChatById(long id);
}
