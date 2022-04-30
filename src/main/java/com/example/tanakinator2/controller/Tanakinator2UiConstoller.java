package com.example.tanakinator2.controller;

import com.example.tanakinator2.dao.Tanakinator2Dao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui")
public class Tanakinator2UiConstoller {
    private final Tanakinator2Dao dao;

    public Tanakinator2UiConstoller(Tanakinator2Dao dao) {
        this.dao = dao;
    }

    @GetMapping(path = "")
    public String home(Model model) {
        String message = dao.getMessage();
        model.addAttribute("message", message);
        return "index";
    }
}
