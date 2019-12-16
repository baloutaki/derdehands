package be.ehb.derdehands.controllers;

import be.ehb.derdehands.model.Data;
import be.ehb.derdehands.model.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {
@Autowired
    DataDAO dao;

    @ModelAttribute(value = "alleProducts")
    public Iterable<Data>getAllProducts(){
        return dao.findAll();
    }

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

    @RequestMapping(value = {"/about"},method = RequestMethod.GET)
    public String showIndexAbout(ModelMap map){
        return "about";
    }


}
