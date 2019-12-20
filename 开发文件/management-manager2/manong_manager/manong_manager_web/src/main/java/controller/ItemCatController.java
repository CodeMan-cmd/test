package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2019/7/28.
 */
@Controller
public class ItemCatController {


    @RequestMapping("/manager")
    public String itemCat(){
        return "index";
    }



}
