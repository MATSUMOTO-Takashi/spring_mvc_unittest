package local.tmatsumoto.app.web.controller.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import local.tmatsumoto.app.entity.Book;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:servlet-context-test.xml"})
@WebAppConfiguration
public class BookControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void book_searchへのGET() throws Exception {
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
