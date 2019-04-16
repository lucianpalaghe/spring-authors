package ro.siit.authorsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.authorsapp.service.AuthorService;

@Controller
@RequestMapping(path = "/authors")
public class AuthorsController {
    @Autowired
    AuthorService authorService;

    @GetMapping(path = "")
    public ModelAndView getAllAuthors(){
        ModelAndView mv = new ModelAndView("authors");
        mv.addObject("authors", authorService.getAllAuthors());
        return mv;
    }



}
