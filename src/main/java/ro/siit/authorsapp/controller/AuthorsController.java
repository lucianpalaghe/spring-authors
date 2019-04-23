package ro.siit.authorsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.authorsapp.model.Author;
import ro.siit.authorsapp.service.AuthorService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/authors")
public class AuthorsController {
    @Autowired
    AuthorService authorService;

    @GetMapping(path = "")
    public ModelAndView getAllAuthors(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("authors");
        mv.addObject("authors", authorService.getAllAuthors());
        return mv;
    }

    @GetMapping("/add")
    public String greetingForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/add")
    public String authorSubmit(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-author";
        }

        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String removeAd(@RequestParam Integer id) {
        authorService.removeAuthorById(id);
        return "redirect:/authors";
    }
}