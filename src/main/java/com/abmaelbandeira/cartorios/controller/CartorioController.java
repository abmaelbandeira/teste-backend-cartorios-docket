package com.abmaelbandeira.cartorios.controller;

import com.abmaelbandeira.cartorios.model.Cartorio;
import com.abmaelbandeira.cartorios.model.Certidao;
import com.abmaelbandeira.cartorios.repository.CertidaoRepository;
import com.abmaelbandeira.cartorios.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartorioController {
    @Autowired
    private CartorioService cartorioService;

    @Autowired
    private CertidaoRepository certidaoRepository;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCartorios", cartorioService.getAllCartorios());
        return "index";
    }

    @GetMapping("/showNewCartorioForm")
    public String showNewCartorioForm(Model model){
        Cartorio cartorio = new Cartorio();
        model.addAttribute("cartorio", cartorio);
        return "new_cartorio";
    }

    @PostMapping("/saveCartorio")
    public String saveCartorio(@ModelAttribute("cartorio") Cartorio cartorio){
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

    // Detail Cartorio
    @RequestMapping(value="/detailCartorio/{id}", method=RequestMethod.GET)
    public ModelAndView detailCartorio(@PathVariable("id")long id){
        Cartorio cartorio = cartorioService.getCartorioById(id);
        ModelAndView mv = new ModelAndView("detailCartorio");
        mv.addObject("cartorio", cartorio);

        Iterable<Certidao> certidoes = certidaoRepository.findByCartorio(cartorio);
        mv.addObject("certidoes", certidoes);
        return mv;
    }

    @RequestMapping(value="/detailCartorio/{id}", method=RequestMethod.POST)
    public String detailCartorioPost(@PathVariable("id") long id, Certidao certidao){
        Cartorio cartorio = cartorioService.getCartorioById(id);
        certidao.setCartorio(cartorio);
        certidaoRepository.save(certidao);
        return "redirect:/detailCartorio/{id}";
    }

    @GetMapping("/deleteCartorio/{id}")
    public String deleteCartorio(@PathVariable(value = "id") long id){

        // call delete cartorio method
        this.cartorioService.deleteCartorioById(id);
        return "redirect:/";
    }


}
