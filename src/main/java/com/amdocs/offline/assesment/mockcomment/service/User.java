package com.amdocs.offline.assesment.mockcomment.service;


import com.amdocs.offline.assesment.exceptions.ApiRequestException;
import com.amdocs.offline.assesment.mockcomment.entity.Comment;
import com.amdocs.offline.assesment.mockcomment.entity.Person;

public class User implements ICommentOperations {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Comment createComment(String message) {
        Comment comment = new Comment(this.person,message);
        return comment;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        if(comment.getAuthor().getName().equals(person.getName()))
        {
            comment=null;
            return true;
        }
        else if(comment.getRepliedTo().getAuthor().getName().equals(this.person.getName()))
        {
            comment=null;
            return true;
        }
        else
           return false;

    }

    @Override
    public boolean editComment(Comment comment, String message) {
        if(this.person.getName().equals(comment.getAuthor().getName())) {
            comment.setMessage(message);
            return true;
        }
        else
            throw new ApiRequestException("You Cann't edit this comment as yourn't the Author");
    }

    @Override
    public Comment replyTo(Comment comment, String message) {
        Comment replyComment = new Comment(this.person,message,comment);
        return replyComment;
    }
}
