package com.amdocs.articles.controller;

import com.amdocs.articles.entity.Articles;
import com.amdocs.articles.service.ArticlesService;
import com.amdocs.articles.service.MarkDownHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@RestController
@PropertySource(value ="classpath:application.properties")
@RequestMapping("/articles")
public class ArticleController
{
    @Autowired
    ArticlesService articleService;

    @Autowired
    MarkDownHeadersService markDownHeadersService;

    @GetMapping("/get/all")
    public HashMap<UUID,Articles> getAll(){
      return articleService.getAll();
    }
    @GetMapping("/get/{uuid}")
    public Articles getArticleByUniqueID(@PathVariable UUID uuid){
        return articleService.getArticleByUniqueID(uuid);
    }

    @GetMapping("/get/date")
    public ArrayList<Articles> getArticlesByDate(@RequestParam String date){
        return articleService.getArticlesByDate(date);
    }

    @PostMapping("/add")

    public String add(@RequestBody Articles article){
        return articleService.add(article);
    }

    @PutMapping("/edit")
    public String edit(@RequestParam UUID uuid,@RequestBody Articles article){
        return articleService.edit(uuid,article);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam UUID uuid){
        return articleService.delete(uuid);
    }

    @PostMapping("/markdownheaders")
    public  String markdownheaders(@RequestBody String markdownheaders)
    {
        return markDownHeadersService.markdownheaders(markdownheaders);
    }
}
