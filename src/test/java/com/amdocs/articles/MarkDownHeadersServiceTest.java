package com.amdocs.articles;

import com.amdocs.articles.service.MarkDownHeadersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MarkDownHeadersServiceTest {

   @Autowired
    MarkDownHeadersService markDownHeadersService ;

    @Test
    public void Testmarkdownheaders()
    {
        String[] headers = {"# Header", "## Header ", "###### Header   "};
        assertAll("headers",
                () -> assertEquals("<h1>Header</h1>", markDownHeadersService.markdownheaders(headers[0])),
                () -> assertEquals("<h2>Header</h2>", markDownHeadersService.markdownheaders(headers[1])),
                () -> assertEquals("<h6>Header</h6>", markDownHeadersService.markdownheaders(headers[2]))
        );
    }


}
