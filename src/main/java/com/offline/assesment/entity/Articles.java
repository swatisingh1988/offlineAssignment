package com.offline.assesment.entity;

import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.UUID;

/** @author <a href  swati.gbpant@gmail.com</>**/

/**
 * Article Bean Class (POJO)
 * Model for Article Project
 **/

public class Articles implements Comparable<Articles> {
    private String title;
    @NonNull
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
//    public static int compareByDateTime(Articles a1,Articles a2){
//        if(a1.getCreateDate().isBefore(a2.getCreateDate()))
//            return 1;
//        if(a1.getCreateDate().isAfter(a2.getCreateDate()))
//            return -1;
//        else
//            return 0;
//
//    }

    public static Comparator<Articles> ArticlesByTitle= new Comparator<Articles>() {
        @Override
        public int compare(Articles o1, Articles o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    @Override
    public int compareTo(Articles o) {
        if(this.getCreateDate().isBefore(o.getCreateDate()))
            return 1;
        if(this.getCreateDate().isAfter(o.getCreateDate()))
            return -1;
        else return 0;
    }


}
