package be.ehb.derdehands.controllers;

import be.ehb.derdehands.model.Data;
import be.ehb.derdehands.model.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class NewController {

    @Autowired
    DataDAO dao;

    @ModelAttribute(value = "nProduct")
    public Data productToSave(){
        return new Data();
    }

    @GetMapping(value = "/new")
    public String show(){
        return "new";
    }

    @RequestMapping(value ={"/new"} ,method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("nProduct") @Valid Data nProduct, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "new";

        dao.save(nProduct);
        return "redirect:/index";
    }
}
