package my.examples.shop.controller;

import my.examples.shop.domain.Account;
import my.examples.shop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    AccountService accountService;
    @GetMapping("/main")
    public String main(Model model){
        List<Account> list = accountService.getAccountAll();
        model.addAttribute("list", list);
        return "index";
    }
}