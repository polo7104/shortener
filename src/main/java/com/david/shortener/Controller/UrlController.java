package com.david.shortener.Controller;


import com.david.shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    @RequestMapping("/")
    public String index(Model model){

        System.out.println(urlService.getUrl(""));

        model.addAttribute("url", urlService.getUrl(""));

        return "index";
    }
}
