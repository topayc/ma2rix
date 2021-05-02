package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.command.CommentCommand;
import com.ma2rix.music.model.domain.Comment;

public interface CommentMapper {
	public int getCommentsCount(String musicClassNo);
	
	public ArrayList<CommentCommand> getCommentCommandList ( 
			@Param("musicClassNo") String musicClassNo, 
			@Param("pageCount") int pageCount, 
			@Param("pageOffset") int pageOffset, 
			@Param("orderBy") int orderBy);	
	
	public ArrayList<Comment> getAllComments(String musicClassNo);	

	public ArrayList<CommentCommand> getAllComments2(
			@Param("musicClassNo") String musicClassNo
			);	

	public ArrayList<Comment> getCommentsByMusicClassNoAndMusicNo(
			@Param("musicClassNo") int musicClassNo,
			@Param("musicNo") int musicNo
			);
	public Comment getCommentByCommentNo(int commentNo);
	public ArrayList<Comment> getCommentsByMemberNo(int memberNo);
	public void insertComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(int commentNo);
	
}
