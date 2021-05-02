package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.CommentDao;
import com.ma2rix.music.dao.mapper.CommentMapper;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.domain.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired CommentMapper commentMapper;
	
	@Override
	public int getCommentsCount(String musicClassNo) {
		return commentMapper.getCommentsCount(musicClassNo);
	}
	
	@Override
	public ArrayList<Comment> getAllComments(String musicClassNo) {
		return commentMapper.getAllComments(musicClassNo);
	}	

	@Override
	public ArrayList<CommentCommand> getAllComments2(String musicClassNo) {
		return commentMapper.getAllComments2(musicClassNo);
	}

	@Override
	public ArrayList<Comment> getCommentsByMusicClassNoAndMusicNo(
			int musicClassNo, int musicNo) {
		return commentMapper.getCommentsByMusicClassNoAndMusicNo(musicClassNo, musicNo);
	}

	@Override
	public Comment getCommentByCommentNo(int commentNo) {
		return commentMapper.getCommentByCommentNo(commentNo);
	}

	@Override
	public void insertComment(Comment comment) {
		commentMapper.insertComment(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		commentMapper.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentNo) {
		commentMapper.deleteComment(commentNo);
	}

	@Override
	public ArrayList<Comment> getCommentsByMemberNo(int memberNo) {
		return commentMapper.getCommentsByMemberNo(memberNo);
	}

	@Override
	public ArrayList<CommentCommand> getCommentCommandList(String musicClassNo,
			int pageCount, int pageOffset, int orderBy) {
		return commentMapper.getCommentCommandList(musicClassNo, pageCount, pageOffset, orderBy);
	}

	@Override
	public int getCommentCount(String musicClassNo) {
		return commentMapper.getCommentsCount(musicClassNo);
	}	


}
