package com.amdocs.offline.assesment.mockcomment.entity;

import java.time.LocalDateTime;

/** @author <a href  swati.gbpant@gmail.com</>**/
public class Comment {

    private Person author;
    private LocalDateTime createdAt;
    private String message;
    private Comment repliedTo;

    public Comment(Person author, String message) {
        this.message = message;
        this.author = author;
        this.setCreatedAt();
    }

    public Comment(Person author, String message, Comment repliedTo) {
        this.message = message;
        this.repliedTo = repliedTo;
        this.author = author;
        this.setCreatedAt();
    }



    public String getMessage() {
        return message;
    }

    public Person getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Comment getRepliedTo() {
        return repliedTo;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.ofInstant(java.time.Instant.now(), java.time.ZoneOffset.UTC);
    }

    public void setRepliedTo(Comment repliedTo) {
        this.repliedTo = repliedTo;
    }


    @Override
    public String toString() {
        if(this.repliedTo == null)
        {
            return this.getMessage()+"by " + author.getName()+"";
        }
        return   this.getMessage()+ " by " +author.getName()+
                "(replied to " +this.getRepliedTo().getAuthor().getName()+ ")";
    }
}
