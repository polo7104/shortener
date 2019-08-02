package com.david.shortener;

import com.david.shortener.service.UrlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShortenerApplicationTests {

    @Autowired
    private UrlService urlService;

    @Test
    public void isExistFnTest() {
        if(urlService.isExist("http://google.com1")){
            System.out.println("Exist");
        }else{
            System.out.println("Not Exist");
        }
    }

}
