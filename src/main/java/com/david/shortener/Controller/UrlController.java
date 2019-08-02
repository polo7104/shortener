package com.david.shortener.Controller;


import com.david.shortener.domain.UrlHitVO;
import com.david.shortener.domain.UrlVO;
import com.david.shortener.service.UrlService;
import com.google.gson.Gson;
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
        return "index";
    }


    @RequestMapping("/500")
    public  String test(){
        return "500";
    }


    @RequestMapping("/put/url")
    public @ResponseBody String insertUrl(UrlVO vo){
        String rt = "";
        String url = vo.getUrl().toString().trim();
        try {
            if(!urlService.isExist(url)){ //check if the url exist
                urlService.insertUrl(vo); // if not insert
            }
            rt = Integer.toHexString((urlService.getUrlId(url).getId())); // return hex string
        } catch (Exception e) {
            e.printStackTrace();
            rt = "0";   // return error
        }finally {
            return rt;
        }
    }

    @RequestMapping("/put/urlHit")
    public String insertUrlHit(UrlHitVO vo){
        String rtUrl = "500";
        try {
            urlService.insertUrlHit(vo); //url_hit table insert
            String[] hexUrls = vo.getUrl().split("/");
            String hexUrl = hexUrls[hexUrls.length-1];
            rtUrl = urlService.getUrl( Integer.parseInt(hexUrl,16) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:"+rtUrl;
    }

    @RequestMapping("/get/history")
    public @ResponseBody String getHistory(){

        Gson gson = new Gson();
        String jsonHit = gson.toJson(urlService.getHistory());
        return jsonHit;
    }


    public String getShortenStr(int num){
        String shortenStr = "";

        return shortenStr;
    }
}
