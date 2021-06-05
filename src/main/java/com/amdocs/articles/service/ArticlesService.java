package com.amdocs.articles.service;

import com.amdocs.articles.entity.Articles;
import com.amdocs.articles.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ArticlesService {

    @Autowired
    ArticlesRepository articlesRepository;

    public HashMap<UUID,Articles> getAll(){
        return articlesRepository.getAll();
    }



    public String add(Articles article )
    {
        //validations
        return articlesRepository.add(article);
    }
    public String edit(UUID uuid,Articles article )
    {
        //validation
        return articlesRepository.edit(uuid,article);
    }

    public String delete(UUID uudi)
    {
        return articlesRepository.delete(uudi);
    }

    public Articles getArticleByUniqueID(UUID uuid) {
        return articlesRepository.getArticleByUniqueID(uuid);
    }

    public ArrayList<Articles> getArticlesByDate(String date) {
        ArrayList<Articles> articlesByDate= new ArrayList<Articles>();
                Iterator articlesIterator = articlesRepository.getAll().entrySet().iterator();

        HashMap<UUID,Articles> articlesbyDate = new HashMap<>();
        articlesRepository.getAll().entrySet().stream()
                .filter( x -> x.getValue().getCreateDate().toLocalDate().equals(LocalDate.parse(date)))
                .forEach(uuidArticlesEntry -> articlesbyDate.put(uuidArticlesEntry.getKey(),uuidArticlesEntry.getValue()));

        while(articlesIterator.hasNext())
        {
            Map.Entry mapArticle = (Map.Entry)articlesIterator.next();

            Articles article= (Articles)mapArticle.getValue();
            if(article.getCreateDate().toLocalDate().equals(LocalDate.parse(date)))
            {
                articlesByDate.add(article);
            }
        }
        articlesByDate.sort(Articles::compareByDateTime);
        return articlesByDate;
    }
}
