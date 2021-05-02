package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.domain.Comment;

public interface CommentDao {

	public int getCommentCount(String musicClassNo);		
	public ArrayList<Comment> getAllComments(String musicClassNo);
	public ArrayList<CommentCommand> getAllComments2(String musicClassNo);
	
	public ArrayList<CommentCommand> getCommentCommandList(
			String musicClassNo,
			int pageCount, 
			int pageOffset, 
			int orderBy);		
	
	public ArrayList<Comment> getCommentsByMusicClassNoAndMusicNo(
			int musicClassNo,
			int musicNo
			);
	
	public Comment getCommentByCommentNo(int commentNo);
	public ArrayList<Comment> getCommentsByMemberNo(int memberNo);
	
	public void insertComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(int commentNo);
	public int getCommentsCount(String musicClassNo);
}
