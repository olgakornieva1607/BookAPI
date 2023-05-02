package pl.coderslab.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
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

    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "/book-add";
    }

    @PostMapping("/add")
    public String handleAddBookForm(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if(result.hasErrors()){
            return "/book-add";
        }
        bookService.add(book);
        log.info("Adding new book - {}", book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model){
        model.addAttribute("bookToEdit", bookService.get(id));
        return "/book-edit";
    }

    @PostMapping("/edit")
    public String handleEditBookForm(@Valid @ModelAttribute("bookToEdit") Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/book-edit";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }


    @GetMapping("/show/{id}")
    public String showBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/book-show";
    }











}
