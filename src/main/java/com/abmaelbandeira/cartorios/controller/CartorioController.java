package com.abmaelbandeira.cartorios.controller;

import com.abmaelbandeira.cartorios.model.Cartorio;
import com.abmaelbandeira.cartorios.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartorioController {
    @Autowired
    private CartorioService cartorioService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCartorios", cartorioService.getAllCartorios());
        return "index";
    }

    @GetMapping("/showNewCartorioForm")
    public String showNewCartorioForm(Model model){
        Cartorio cartorio = new Cartorio();
        model.addAttribute("cartorio", cartorio);
        return "new_catorio";
    }

    @PostMapping("/saveCartorio")
    public String saveCatorio(@ModelAttribute("cartorio") Cartorio cartorio){
        // save cartorio to database
        cartorioService.saveCartorio(cartorio);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){

        // get cartorio from the service
        Cartorio cartorio = cartorioService.getCartorioById(id);

        // set cartorio as a model attribute to pre-populate the form
        model.addAttribute("cartorio", cartorio);
        return "update_cartorio";
    }

    @GetMapping("/deleteCartorio/{id}")
    public String deleteCartorio(@PathVariable(value = "id") long id){

        // call delete cartorio method
        this.cartorioService.deleteCartorioById(id);
        return "redirect:/";
    }


}
