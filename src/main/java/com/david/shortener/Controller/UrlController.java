package com.david.shortener.Controller;


import com.david.shortener.domain.UrlHitVO;
import com.david.shortener.domain.UrlVO;
import com.david.shortener.service.UrlService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    @RequestMapping("/")
    public String index(Model model){

        System.out.println(urlService.isExist("http://google.com1"));
        if(urlService.isExist("http://google.com1")){

        }else{

        }


        model.addAttribute("url", urlService.getUrl(""));

        return "index";
    }


    @RequestMapping("/test")
    public @ResponseBody String test(@ModelAttribute UrlVO vo){
        System.out.println(vo);
        return vo.toString();
    }


    @RequestMapping("/put/url")
    public @ResponseBody int insertUrl(UrlVO vo){
        int rt = 0;

        try {
            urlService.insertUrl(vo);
            rt = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return rt;
        }
    }

    @RequestMapping("/put/urlHit")
    public @ResponseBody int insertUrlHit(UrlHitVO vo){
        int rt = 0;

        try {
            urlService.insertUrlHit(vo);
            rt = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return rt;
        }
    }
}
