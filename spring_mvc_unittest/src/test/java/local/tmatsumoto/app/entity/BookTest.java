package local.tmatsumoto.app.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookTest {
	
	private Book book = new Book();

	@Test
	public void isR18はgetTargetAgeがnullならfalseを返す() {
		Whitebox.setInternalState(book, "targetAge", null);
		boolean res = book.isR18();
		
		assertThat(res, is(false));
	}
	
	@Test
	public void isR18はgetTargetAgeが18未満ならfalseを返す() {
		Whitebox.setInternalState(book, "targetAge", 17);
		boolean res = book.isR18();
		
		assertThat(res, is(false));
	}
	
	@Test
	public void isR18はgetTargetAgeが18以上ならtrueを返す() {
		Whitebox.setInternalState(book, "targetAge", 18);
		boolean res = book.isR18();
		
		assertThat(res, is(true));
	}

}
