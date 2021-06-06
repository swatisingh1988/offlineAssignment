package com.amdocs.offline.assesment.mockcomment.service;


import com.amdocs.offline.assesment.mockcomment.entity.Comment;
import com.amdocs.offline.assesment.mockcomment.entity.Person;

/** @author <a href  swati.gbpant@gmail.com</>**/
public class Moderator implements ICommentOperations {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public boolean deleteComment(Comment comment) {
        comment=null;
        return true;
    }
}
