package local.tmatsumoto.app.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import local.tmatsumoto.app.entity.Book;
import local.tmatsumoto.app.service.BookService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private BookController bookController;
	
	@Mock
	private BookService bookService;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	@Test
	public void book_searchへのGET() throws Exception {
		Book book = new Book();
		book.setId("10");
		book.setName("Java");
		book.setAuthor("tmatsumoto");
		
		when(bookService.findById("10"))
				.thenReturn(book);
		
		MvcResult mvcResult = mockMvc.perform(get("/book/search").param("id", "10"))
				.andExpect(status().isOk())
				.andExpect(view().name("searchResult"))
				.andExpect(model().hasNoErrors())
				.andReturn();
		
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Book modelBook = (Book) modelMap.get("book");
		
		assertThat(modelBook.getId(), is("10"));
	}

}
