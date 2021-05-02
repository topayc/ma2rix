package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.CommentDao;
import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.domain.Comment;
import com.ma2rix.music.service.interfaces.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired CommentDao commentDao;
	
	@Override	
	public int getCommentCount(String musicClassNo){
		return commentDao.getCommentCount(musicClassNo);
	}	


	@Override
	public ArrayList<Comment> getAllComments(String musicClassNo) {
		return commentDao.getAllComments(musicClassNo);
	}
	
	@Override
	public ArrayList<CommentCommand> getAllComments2(String musicClassNo) {
		return commentDao.getAllComments2(musicClassNo);
	}	

	@Override
	public ArrayList<Comment> getCommentsByMusicClassNoAndMusicNo(
			int musicClassNo, int musicNo) {
		return commentDao.getCommentsByMusicClassNoAndMusicNo(musicClassNo, musicNo);
	}

	@Override
	public Comment getCommentByCommentNo(int commentNo) {
		return commentDao.getCommentByCommentNo(commentNo);
	}

	@Override
	public void insertComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public void insertComment(String musicClassNo, int musicNo, int memberNo,
			String commentContents) {
		Comment comment = new Comment();
		comment.setMemberNo(memberNo);
		comment.setCommentContents(commentContents);
		comment.setMusicClassNo(musicClassNo);
		comment.setMusicNo(musicNo);
		this.insertComment(comment);
		
	}
	
	@Override
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentNo) {
		commentDao.deleteComment(commentNo);
	}


	@Override
	public ArrayList<Comment> getCommentsByMemberNo(int memberNo) {
		return commentDao.getCommentsByMemberNo(memberNo);
	}

	@Override
	public int getCommentsCount(String musicClassNo) {
		return commentDao.getCommentsCount(musicClassNo);
	}
	
	@Override
	public ArrayList<CommentCommand> getCommentCommandList(String musicClassNo,
			int pageCount, int pageOffset, int orderBy) {
		return commentDao.getCommentCommandList(musicClassNo, pageCount, pageOffset, orderBy);
	}			

}
