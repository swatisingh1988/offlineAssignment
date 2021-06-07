package com.amdocs.offline.assesment.mockcomment.service;

import com.amdocs.offline.assesment.mockcomment.entity.Comment;
import com.amdocs.offline.assesment.mockcomment.entity.ValidUser;

/** @author <a href  swati.gbpant@gmail.com</>**/

public class Admin extends ValidUser {

    @Override
    public Comment createComment(String message) {
        Comment comment = new Comment(this.getPerson(),message);
        return comment;
    }

    @Override
    public boolean editComment(Comment comment, String message) {
        comment.setMessage(message);
        comment.setCreatedAt();
        return true;
    }
    @Override
    public boolean deleteComment(Comment comment) {
        comment=null;
        return true;
    }
}
