package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.domain.Comment;

@Transactional
public interface CommentService {
	
	public static final int PAGE_OFFSET = 10;

	public int getCommentCount(String musicClassNo);	
	public ArrayList<Comment> getAllComments(String musicClassNo);
	public ArrayList<CommentCommand> getAllComments2(String musicClassNo);
	
	public ArrayList<CommentCommand> getCommentCommandList (String musicClassNo, 
			int pageCount,
			int pageOffset,
			int orderBy);	
	
	public ArrayList<Comment> getCommentsByMusicClassNoAndMusicNo(
			int musicClassNo,
			int musicNo
			);
	
	public Comment getCommentByCommentNo(int commentNo);
	public ArrayList<Comment> getCommentsByMemberNo(int memberNo);
	
	public void insertComment(String musicClassNo, int musicNo,int memberNo, String commentContents);
	public void insertComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(int commentNo);
	public int getCommentsCount(String musicClassNo);

}
