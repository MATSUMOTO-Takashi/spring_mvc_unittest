package local.tmatsumoto.app.service.impl;

import org.springframework.stereotype.Service;

import local.tmatsumoto.app.entity.Book;
import local.tmatsumoto.app.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Override
	public Book findById(String id) {
		Book book = new Book();
		book.setId(id);
		book.setName("Java");
		book.setAuthor("tmatsumoto");
		
		return book;
	}

}
