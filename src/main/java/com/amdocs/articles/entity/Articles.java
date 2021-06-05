package com.amdocs.articles.entity;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Article Bean Class (POJO)
 * Model for Article Project
 **/

public class Articles {

    private String title;
    private String body;
    private LocalDateTime createDate;
    UUID uuid = UUID.randomUUID();

    public Articles ()
    {
        super();
    }

    public Articles (String title , String body , LocalDateTime createDate)
    {
        super();
        this.body = body;
        this.title = title;
        this.createDate = createDate;
    }

    public LocalDateTime getCreateDate()
    {
        if (createDate==null) {
            createDate = LocalDateTime.ofInstant(java.time.Instant.now(), java.time.ZoneOffset.UTC);
        }

        return createDate;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public static int compareByDateTime(Articles a1,Articles a2){
        if(a1.getCreateDate().isBefore(a2.getCreateDate()))
            return 1;
        if(a1.getCreateDate().isAfter(a2.getCreateDate()))
            return -1;
        else
            return 0;

    }
}
