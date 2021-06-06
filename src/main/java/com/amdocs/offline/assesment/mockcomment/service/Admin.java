package com.amdocs.offline.assesment.mockcomment.service;

import com.amdocs.offline.assesment.mockcomment.entity.Comment;

/** @author <a href  swati.gbpant@gmail.com</>**/

public class Admin extends Moderator  {

    @Override
    public Comment createComment(String message) {
        Comment comment = new Comment(super.getPerson(),message);
        return comment;
    }

    @Override
    public boolean editComment(Comment comment, String message) {
        comment.setMessage(message);
        comment.setCreatedAt();
        return true;
    }
}
