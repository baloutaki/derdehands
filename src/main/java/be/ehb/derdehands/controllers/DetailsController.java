package be.ehb.derdehands.controllers;

import be.ehb.derdehands.model.Data;
import be.ehb.derdehands.model.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DetailsController {
    @Autowired
    DataDAO dao;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetailsForID(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<Data> optional = dao.findById(id);
            return "details";
        }
    }




