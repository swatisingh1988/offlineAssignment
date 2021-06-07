package com.amdocs.offline.assesment.mockcomment.service;


import com.amdocs.offline.assesment.mockcomment.entity.Comment;
import com.amdocs.offline.assesment.mockcomment.entity.ValidUser;

/** @author <a href  swati.gbpant@gmail.com</>**/
public class Moderator extends ValidUser {

    @Override
    public boolean deleteComment(Comment comment) {
        comment=null;
        return true;
    }
}
