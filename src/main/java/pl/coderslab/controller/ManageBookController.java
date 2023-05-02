package pl.coderslab.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("admin/books")
public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books-all";
    }








}
