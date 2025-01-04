package com.lzq.springmvc.controller;

import com.lzq.springmvc.bean.User;
import com.lzq.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserControlle {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @RequestMapping(value = "/user/selectAll",method = RequestMethod.GET)
    public String selectAll(Model model){
        List<User> users = userDao.selectAll();
        model.addAttribute("users",users);
        return "user_list";
    }
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public String insert(User user){
       userDao.insert(user);
        return "redirect:/user/selectAll";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String detial(@PathVariable("id") Long id, Model model){
        System.out.println(id);
        User userById = userDao.getUserById(id);
        model.addAttribute("user",userById);
        System.out.println(userById);
        return "user_edit";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String put(User user){

        userDao.update(user);
        return "redirect:/user/selectAll";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){

        userDao.deleteById(id);
        return "redirect:/user/selectAll";
    }
}
