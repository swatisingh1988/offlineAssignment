package com.offline.assesment;

import com.offline.assesment.controller.MarkDownController;
import com.offline.assesment.service.MarkDownHeadersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MarkDownHeadersServiceTest {

   @Autowired
   MarkDownHeadersService markDownHeadersService ;

   @Autowired
   MarkDownController markDownController;

    @Test
    public void Testmarkdownheaders()
    {
        String[] headers = {"# Header", "## Header ", "###### Header   ", "tiuwtrgb","##########ajkdsj","####    IYUIY", "#### %%^&&**ASDFFGD!@#$%$%123456"};
        assertAll("headers",
                () -> assertEquals("<h1>Header</h1>", markDownHeadersService.markdownheaders(headers[0])),
                () -> assertEquals("<h2>Header</h2>", markDownHeadersService.markdownheaders(headers[1])),
                () -> assertEquals("<h6>Header</h6>", markDownHeadersService.markdownheaders(headers[2])),
                () -> assertEquals("tiuwtrgb", markDownHeadersService.markdownheaders(headers[3])),
                () -> assertEquals("##########ajkdsj", markDownHeadersService.markdownheaders(headers[4])),
                () -> assertEquals("<h4>IYUIY</h4>", markDownHeadersService.markdownheaders(headers[5])),
                () -> assertEquals("<h4>%%^&&**ASDFFGD!@#$%$%123456</h4>", markDownHeadersService.markdownheaders(headers[6]))
        );
    }

}
