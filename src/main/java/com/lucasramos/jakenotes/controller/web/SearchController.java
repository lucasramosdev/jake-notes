package com.lucasramos.jakenotes.controller.web;

import com.lucasramos.jakenotes.domain.note.NoteComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private NoteComponent noteComponent;

    @GetMapping
    public String searchPage(Model model, @RequestParam(value = "q") String query) {
        model.addAttribute("styles", List.of("/css/search.css"));
        model.addAttribute("content", "search");
        model.addAttribute("query", query);
        model.addAttribute("notes", noteComponent.searchNotes(query, 0));
        return "layout";
    }


}