package net.softsociety.ajax.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.ajax.domain.Comment;

@Mapper
public interface CommentDAO {
    //댓글 저장
    public int insertComment(Comment comment);
    //댓글 목록 조회
    public ArrayList<Comment> listComment();
    //댓글 삭제
    public int deleteComment(int num);
    
}
