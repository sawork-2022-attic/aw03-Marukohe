package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        double subtotal = posService.total(posService.getCart());
        double total = (double) Math.round(subtotal * 112) / 100;
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("total", total);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "index";
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id")String id) {
        posService.add(id, 1);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")String id) {
        posService.add(id, -1);
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id")String id) {
        posService.remove(id);
        return "redirect:/";
    }

    @RequestMapping("/checkout")
    public String checkOut() {
        posService.newCart();
        return "redirect:/";
    }
}
