package by.nagula.service;

import by.nagula.entity.Comment;
import by.nagula.repository.CommentRepository;
import by.nagula.service.exception.WrongIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> showAllCommentsByChatId(long id) {
        if (id > 0){
            return commentRepository.findAllByChatId(id);
        } else {
            throw new WrongIdException("Wrong id");
        }
    }

    @Override
    public void removeComment(long id) {
        if (id > 0){
            commentRepository.deleteById(id);
        } else {
            throw new WrongIdException("Wrong id");
        }
    }
}
