package moyeora.myapp.service.impl;

import lombok.RequiredArgsConstructor;
import moyeora.myapp.dao.CommentDao;
import moyeora.myapp.dao.PostDao;
import moyeora.myapp.dao.UserDao;

import moyeora.myapp.service.CommentService;
import moyeora.myapp.vo.Comment;
import moyeora.myapp.vo.School;
import moyeora.myapp.vo.SchoolUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DefaultCommentService implements CommentService {

  private final CommentDao commentDao;
  UserDao userDao;

  @Transactional
  @Override
  public void addComment(Comment comment) {

    commentDao.addComment(comment);

  }

  @Transactional
  @Override
  public void update(Comment comment) {

    commentDao.update(comment);
  }

  @Override
  public void delete(int commentNo) {
    commentDao.delete(commentNo);
  }


  @Override
  public List<Comment> get(int no) {
    return commentDao.findByComment(no);
  }
}
