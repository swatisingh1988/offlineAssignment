package com.offline.assesment.service;


import com.offline.assesment.entity.Articles;
import com.offline.assesment.exceptions.ApiRequestException;
import com.offline.assesment.repository.ArticlesRepository;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/** @author <a href  swati.gbpant@gmail.com</>**/

@Service
public class ArticlesService {

    Logger logger = LoggerFactory.getLogger(ArticlesService.class);

    @Autowired
    ArticlesRepository articlesRepository;

    public HashMap<UUID,Articles> getAll(){

        logger.trace("In ArticlesService getAll call ");
        return articlesRepository.getAll();
    }

    public Pair<UUID,Articles> add(Articles article )
    {
        logger.trace("In ArticlesService add call ");
        return articlesRepository.add(article);
    }
    public Pair<UUID,Articles> edit(UUID uuid,Articles article )
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

    public  HashMap<UUID,Articles> getArticlesByDate(String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);
        }catch (Exception e)
        {
            logger.error(date+"Date isn't Valid");
            throw new ApiRequestException("Entered Date isn't Valid, please try again");
        }
        logger.info(date+"Streaming through repository for provided date articles");
        HashMap<UUID,Articles> articlesByDate = new LinkedHashMap<UUID,Articles>();
                articlesRepository.getAll().entrySet()
                .stream()
                .filter( x -> x.getValue().getCreateDate().toLocalDate().equals(LocalDate.parse(date)))
                .sorted(Comparator.comparing(Map.Entry::getValue,Articles.ArticlesByTitle.thenComparing(Articles::getCreateDate)))
                .forEachOrdered((e)-> {
                    UUID key = e.getKey();
                    Articles value = e.getValue();
                    articlesByDate.put(key,value);
                });

        return articlesByDate;
    }
}
