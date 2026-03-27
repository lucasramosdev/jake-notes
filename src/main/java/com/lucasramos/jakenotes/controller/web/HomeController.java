package com.lucasramos.jakenotes.controller.web;

import com.lucasramos.jakenotes.domain.note.NoteComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private NoteComponent noteComponent;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("styles", List.of("/css/home.css"));
        model.addAttribute("content", "home");
        model.addAttribute("notes", noteComponent.getRecentNotes());
        return "layout";
    }

    @GetMapping("/home")
    public RedirectView redirect() {
        return new RedirectView("");
    }
}