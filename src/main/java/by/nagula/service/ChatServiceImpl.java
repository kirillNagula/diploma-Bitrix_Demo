package by.nagula.service;

import by.nagula.entity.Chat;
import by.nagula.repository.ChatRepository;
import by.nagula.service.exception.NoChatException;
import by.nagula.service.exception.WrongIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public void createChat(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void removeChat(long id) {
        if(id > 0){
            chatRepository.deleteById(id);
        } else {
            throw new WrongIdException("Wrong id exception");
        }

    }

    @Override
    public List<Chat> showAllChats() {
        return chatRepository.findAll();
    }

    @Override
    public Chat showChatById(long id) {
        if (id > 0){
            if (chatRepository.findById(id).isPresent()){
                return chatRepository.findById(id).get();
            } else {
                throw new NoChatException("This chat not created");
            }
        } else {
            throw new WrongIdException("Wrong id exception");
        }
    }

    @Override
    public void updateChat(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public List<Chat> showChatsByUserId(long id) {
        if (id > 0){
            return chatRepository.findAllByUserListId(id);
        } else {
            throw new WrongIdException("Wrong id exception");
        }
    }
}
