package com.amdocs.articles.repository;

import com.amdocs.articles.entity.Articles;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class ArticlesRepository {

   public HashMap<UUID,Articles> articleCollection = new HashMap();


   public HashMap<UUID,Articles> getAll()
   {
       return articleCollection;
   }

   public String add(Articles article)
   {
       UUID uuid = UUID.randomUUID();
       articleCollection.put(uuid,article);
      return "Successfully added";
   }

    public String edit(UUID uuid,Articles article)
    {
        if(articleCollection.containsKey(uuid))
            articleCollection.put(uuid,article);
        return "Sucessfull edit";
    }

    public String delete(UUID uuid)
    {
       Articles articles= articleCollection.get(uuid);
        LocalDateTime sysdate = LocalDateTime.now();
       if(sysdate.minus(1, ChronoUnit.YEARS).isAfter(articles.getCreateDate()))
        articleCollection.remove(uuid);
        return "Deleted successfully";
    }

    public Articles getArticleByUniqueID(UUID uuid) {
        return articleCollection.get(uuid);
    }


}
