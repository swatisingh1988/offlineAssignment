package com.offline.assesment.controller;

import com.offline.assesment.entity.Articles;
import com.offline.assesment.service.ArticlesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/** @author <a href  swati.gbpant@gmail.com</>**/

@RestController
@RequestMapping("/articles")
public class ArticleController
{
    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticlesService articleService;

    @GetMapping("/get/all")
    public HashMap<UUID, Articles> getAll(){
      logger.debug("Inside /get/all ");
        return articleService.getAll();
    }

    @GetMapping("/get/{uuid}")
    public Articles getArticleByUniqueID(@PathVariable UUID uuid)  {
        logger.trace("/get/{uuid} ");
        return articleService.getArticleByUniqueID(uuid);
    }

    @GetMapping("/get/date")
    public List<Articles> getArticlesByDate(@RequestParam String date){
        logger.debug("/get/date ");
        return articleService.getArticlesByDate(date);
    }

    @PostMapping("/add")

    public String add(@RequestBody Articles article){
        logger.debug("/add ");
        return articleService.add(article);
    }

    @PutMapping("/edit")
    public String edit(@RequestParam UUID uuid,@RequestBody Articles article){
        logger.debug("/edit ");
        return articleService.edit(uuid,article);
    }

    @DeleteMapping("/delete")

    public String delete(@RequestParam UUID uuid){
        logger.debug("/delete");
        return articleService.delete(uuid);
    }


}
