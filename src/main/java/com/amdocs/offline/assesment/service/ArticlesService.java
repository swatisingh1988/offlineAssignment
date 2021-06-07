package com.amdocs.offline.assesment.service;

import com.amdocs.offline.assesment.controller.ArticleController;
import com.amdocs.offline.assesment.entity.Articles;
import com.amdocs.offline.assesment.exceptions.ApiRequestException;
import com.amdocs.offline.assesment.repository.ArticlesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/** @author <a href  swati.gbpant@gmail.com</>**/

@Service
public class ArticlesService {

    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticlesRepository articlesRepository;

    public HashMap<UUID,Articles> getAll(){

        logger.trace("In ArticlesService getAll call ");
        return articlesRepository.getAll();
    }

    public String add(Articles article )
    {
        logger.trace("In ArticlesService add call ");
        return articlesRepository.add(article);
    }
    public String edit(UUID uuid,Articles article )
    {
        logger.trace("In ArticlesService add edit ");
        return articlesRepository.edit(uuid,article);
    }

    public String delete(UUID uudi)
    {
        logger.trace("In ArticlesService delete edit ");
        return articlesRepository.delete(uudi);
    }

    public Articles getArticleByUniqueID(UUID uuid) {
        logger.trace("In ArticlesService getArticleByUniqueID");
        return articlesRepository.getArticleByUniqueID(uuid);
    }

    public HashMap<UUID,Articles>getArticlesByDate(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);
        }catch (Exception e)
        {
            logger.error(date+"Date isn't Valid");
            throw new ApiRequestException("Entered Date isn't Valid, please try again");
        }

        ArrayList<Articles> articlesByDate= new ArrayList<Articles>();
                Iterator articlesIterator = articlesRepository.getAll().entrySet().iterator();

        logger.info(date+"Streaming through repository for provided date articles");
        HashMap<UUID,Articles> articlesbyDate = new HashMap<>();
        articlesRepository.getAll().entrySet().stream()
                .filter( x -> x.getValue().getCreateDate().toLocalDate().equals(LocalDate.parse(date)))
                .forEach(uuidArticlesEntry -> articlesbyDate.put(uuidArticlesEntry.getKey(),uuidArticlesEntry.getValue()));

        articlesbyDate.entrySet().stream().sorted(Comparator.comparing(x-> x.getValue().getCreateDate()));

       /* while(articlesIterator.hasNext())
        {
            Map.Entry mapArticle = (Map.Entry)articlesIterator.next();

            Articles article= (Articles)mapArticle.getValue();
            if(article.getCreateDate().toLocalDate().equals(LocalDate.parse(date)))
            {
                articlesByDate.add(article);
            }
        }
        articlesByDate.sort(Articles::compareByDateTime);
        if(articlesByDate.size()==0)
        {
            logger.error("No Article present for "+date);
            throw new ApiRequestException("No Article present for "+date);
        }*/
        if(articlesbyDate.size()==0)
        {
            logger.error("No Article present for "+date);
            throw new ApiRequestException("No Article present for "+date);
        }
        return articlesbyDate;
    }
}
