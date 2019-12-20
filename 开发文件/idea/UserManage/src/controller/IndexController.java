package controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import util.Pager;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  13:59
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/Index", "/"}, method = RequestMethod.GET)
    public ModelAndView toIndex(ModelAndView modelAndView, HttpSession session, @RequestParam(defaultValue = "1", required = false) Integer current) {
        Pager pager = new Pager(userService.count(), current);
        List<User> users = userService.listAll(pager);
        modelAndView.addObject("listAll", users);
        session.setAttribute("pager", pager);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/toAdd", "/ToAdd"}, method = RequestMethod.GET)
    public String toAdd() {
        return "add";
    }

    @RequestMapping(value = {"/add", "/Add"}, method = RequestMethod.POST)
    public String add(User user) {
        userService.add(user);
        return "redirect:index";
    }

    @RequestMapping(value = {"/remove", "/Remove"}, method = RequestMethod.GET)
    public String remove(Integer id) {
        userService.remove(id);
        return "redirect:index";
    }

    @RequestMapping(value = {"/toModify", "/ToModify"}, method = RequestMethod.GET)
    public ModelAndView toModify(ModelAndView modelAndView, Integer id) {
        modelAndView.addObject("aUser", userService.getById(id));

        modelAndView.setViewName("modify");
        return modelAndView;
    }

    @RequestMapping(value = {"/modify", "/Modify"}, method = RequestMethod.POST)
    public String modify(User user) {
        userService.modify(user);
        return "redirect:index";
    }
}
