package com.offline.assesment.repository;


import com.offline.assesment.entity.Articles;
import com.offline.assesment.exceptions.ApiRequestException;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;

/** @author <a href  swati.gbpant@gmail.com</>**/

@Repository
public class ArticlesRepository {

    Logger logger = LoggerFactory.getLogger(ArticlesRepository.class);

   public HashMap<UUID, Articles> articleCollection = new HashMap();


   public HashMap<UUID,Articles> getAll()
   {
       if(articleCollection.isEmpty())
       {
           logger.error("No data present in repository, please add data and try again ");
           throw new ApiRequestException("Articles repository is empty");
       }
       return articleCollection;
   }

   public Pair<UUID,Articles> add(Articles article)
   {
       if(article.getBody()==null || article.getTitle()==null) {
           logger.error("Title and Body should be present to add an article ");
           throw new ApiRequestException("Title and Body should be present to add an article ");
       }
       UUID uuid = UUID.randomUUID();
       articleCollection.put(uuid,article);
       Pair pair = new Pair<UUID,Articles>(uuid,articleCollection.get(uuid));
       return pair;
   }

    public Pair<UUID,Articles> edit(UUID uuid,Articles article)
    {
        if(articleCollection.containsKey(uuid))
            articleCollection.put(uuid,article);
        else {
            logger.error(uuid+"uuid doesn't exit in Article Record for updation");
            throw new ApiRequestException("Entered uuid doesn't exit in Article Record for updation");
        }
        Pair pair = new Pair<UUID,Articles>(uuid,articleCollection.get(uuid));
        return pair;
    }

    public String delete(UUID uuid)
    {
        if (!articleCollection.containsKey(uuid)) {
            logger.error(uuid+"uuid doesn't exit in Article Record for deletion");
            throw new ApiRequestException("Entered uuid doesn't exit in Article Record for deletion");
        }
        else {
            Articles articles = articleCollection.get(uuid);
            LocalDateTime sysdate = LocalDateTime.now();
            if (sysdate.minus(1, ChronoUnit.YEARS).isAfter(articles.getCreateDate()))
                articleCollection.remove(uuid);
            else {
                logger.error(uuid+"Entered Article can not be deleted as it not older then 1 year");
                throw new ApiRequestException("Entered Article can not be deleted as it not older then 1 year");
            }
        }
        return "Deleted successfully";
    }

    public Articles getArticleByUniqueID(UUID uuid) {
            if (!articleCollection.containsKey(uuid)) {
                logger.error(uuid+"uuid doesn't exit in Article Record");
                throw new ApiRequestException("Entered uuid doesn't exit in Article Record");
            } else
                return articleCollection.get(uuid);

    }


}
