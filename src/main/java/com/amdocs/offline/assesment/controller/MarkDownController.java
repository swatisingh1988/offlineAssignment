package com.amdocs.offline.assesment.controller;

import com.amdocs.offline.assesment.service.MarkDownHeadersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author <a href  swati.gbpant@gmail.com</>**/

@RestController
@RequestMapping("/markdown")
public class MarkDownController {

    @Autowired
    MarkDownHeadersService markDownHeadersService;

    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @PostMapping( path="/markdownheaders")
    public  String markdownheaders(@RequestBody String markdownheaders)
    {
        logger.info("in Controller for mapping of markdownheaders");
        return markDownHeadersService.markdownheaders(markdownheaders);
    }
}
