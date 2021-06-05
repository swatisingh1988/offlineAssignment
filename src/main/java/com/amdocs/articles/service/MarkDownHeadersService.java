package com.amdocs.articles.service;


import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MarkDownHeadersService {


//    @Value("${application.markdown.atx.pattern.regexp}")
//    private  static String atxPattern;
//
//    @Value("${application.markdown.html.pattern}")
//    private static String HTML_HEADER_PATTERN;

//    public static final Pattern MARKDOWN_PATTERN = Pattern.compile(atxPattern);

    public static final Pattern MARKDOWN_PATTERN = Pattern.compile("abc");
    private static String HTML_HEADER_PATTERN = "abc";

    public String markdownheaders(String markdownheaders)
    {

        String htmlcode = markdownheaders;
           if(markdownheaders != null)
                {
                    Matcher matcher = MARKDOWN_PATTERN.matcher(markdownheaders);
                    if (matcher.find())
                    {
                        int hashcount = matcher.group("hash").toString().length();
                        String headerContent = matcher.group("header").trim();
                        htmlcode= MessageFormat.format(HTML_HEADER_PATTERN,hashcount,headerContent,hashcount);
                    }
                }
           return  htmlcode;

    }
}
