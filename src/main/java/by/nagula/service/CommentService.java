package by.nagula.service;

import by.nagula.entity.Comment;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);
    List<Comment> showAllCommentsByChatId(long id);
    void removeComment(long id);
}
