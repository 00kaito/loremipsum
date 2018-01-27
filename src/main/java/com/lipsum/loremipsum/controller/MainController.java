package com.lipsum.loremipsum.controller;

import com.lipsum.loremipsum.model.FormService;
import com.lipsum.loremipsum.model.forms.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    FormService formService;

    @GetMapping("/")
    public String homeGet(@ModelAttribute("form") Form form, Model model) {
        model.addAttribute("lipsum", formService.getLIPSUM());
        return "index";
    }

    @PostMapping("/")
    public String homePost(@ModelAttribute("form") Form form, Model model) {
        String type = form.getType();
        String lipsum="";
        if (form.getNumber()<1){
            model.addAttribute("lipsum", "number field should be more than 0");
            return "index";
        }

        switch (type) {
            case "list" :  lipsum = formService.generateList(form.getNumber());
                break;
            case "paragraph" :  lipsum = formService.generateParagraphs(form.getNumber());
                break;
            case "words" :  lipsum = formService.generateWords(form.getNumber());
                break;
        }
        model.addAttribute("lipsum", lipsum);
        return "index";
    }
}
