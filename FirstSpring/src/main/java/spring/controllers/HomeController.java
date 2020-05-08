package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.db.DBManager;
import spring.db.books;

import java.util.ArrayList;

@Controller
public class HomeController {


    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<books> books = DBManager.getAllBooks();
        model.addAttribute("books",books);
        return "index";
    }

    @PostMapping(value = "/addBook")
    public String addBook(@RequestParam(name = "nameBook") String name,
                          @RequestParam(name = "authorBook") String author,
                          @RequestParam(name = "priceBook") int price,
                          Model model){

        books book = new books(null,name,author,price);
        DBManager.addBook(book);
        return "redirect:/?success";
    }

    @GetMapping(value = "/searchPage")
    public String searchPage(){
        return "search";
    }

    @PostMapping(value = "/searchBook")
    public String search(@RequestParam(name = "name") String name,Model model){
        ArrayList<books> searchBooks = DBManager.searchByName(name);
        model.addAttribute("searchBooks",searchBooks);
        return "redirect:/searchPage";

    }



}
