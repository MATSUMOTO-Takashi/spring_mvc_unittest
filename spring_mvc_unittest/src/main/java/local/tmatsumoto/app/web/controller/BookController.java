package local.tmatsumoto.app.web.controller;

import local.tmatsumoto.app.entity.Book;
import local.tmatsumoto.app.service.BookService;
import local.tmatsumoto.app.web.form.SearchForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@ModelAttribute("searchForm")
	public SearchForm searchForm() {
		return new SearchForm();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(SearchForm searhForm, BindingResult result, Model model) {
		Book book = bookService.findById(searhForm.getId());
		model.addAttribute("book", book);
		return "searchResult";
	}
	
}
