package com.offline.assesment.service;
import com.offline.assesment.controller.ArticleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author <a href  swati.gbpant@gmail.com</>**/
@Service
public class MarkDownHeadersService {


    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    public  static String atxPattern="(?<hash>^[#]{1,6})\\s(?<header>.+)";

    public static String HTML_HEADER_PATTERN="<h{0,number,#0}>{1}</h{2,number,#0}>";

    public static final Pattern MARKDOWN_PATTERN = Pattern.compile(atxPattern);

    public String markdownheaders(String markdownheaders)
    {
        logger.trace("inside markdownheaders");
        logger.info("Provided String is "+markdownheaders);

        String htmlcode = markdownheaders;
           if(markdownheaders != null)
                {
                    logger.trace("inside if markdownheaders isn't null");
                    Matcher matcher = MARKDOWN_PATTERN.matcher(markdownheaders);
                    if (matcher.find())
                    {
                        logger.info("Processing entered String which is in valid format for mark down");
                        int hashcount = matcher.group("hash").toString().length();
                        String headerContent = matcher.group("header").trim();
                        htmlcode= MessageFormat.format(HTML_HEADER_PATTERN,hashcount,headerContent,hashcount);
                    }
                    else
                    {
                        logger.warn("Provided input can not be parsed and will be returned as is");
                    }
                }
           return  htmlcode;

    }
}
