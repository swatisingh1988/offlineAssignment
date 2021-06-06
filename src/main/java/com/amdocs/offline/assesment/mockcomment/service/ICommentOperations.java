package com.amdocs.offline.assesment.mockcomment.service;


import com.amdocs.offline.assesment.mockcomment.entity.Comment;

/** @author <a href  swati.gbpant@gmail.com</>**/
public interface ICommentOperations {

    public default Comment createComment(String message)
    {
        return null;
        //Relevant implementation and exception to user
    }
    public default boolean deleteComment(Comment comment){
        //Relevant implementation and exception to user
        return false;
    }
    public default boolean editComment(Comment comment,String message){
        //Relevant implementation and exception to user
        return false;
    }
    public default Comment replyTo(Comment comment,String message){
        //Relevant implementation and exception to user
        return null;
    }
}
