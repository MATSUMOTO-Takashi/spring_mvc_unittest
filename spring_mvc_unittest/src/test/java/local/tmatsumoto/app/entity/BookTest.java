package local.tmatsumoto.app.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

public class BookTest {
	
	private Book book = new Book();

	@Test
	public void isR18はgetTargetAgeがnullならfalseを返す() {
		Whitebox.setInternalState(book, "targetAge", null);
		
		assertThat(book.getTargetAge(), is(nullValue()));
		assertThat(book.isR18(), is(false));
	}
	
	@Test
	public void isR18はgetTargetAgeが18未満ならfalseを返す() {
		Whitebox.setInternalState(book, "targetAge", 17);
		
		assertThat(book.getTargetAge(), is(lessThan(18)));
		assertThat(book.isR18(), is(false));
	}
	
	@Test
	public void isR18はgetTargetAgeが18以上ならtrueを返す() {
		Whitebox.setInternalState(book, "targetAge", 18);
		
		assertThat(book.getTargetAge(), is(greaterThanOrEqualTo(18)));
		assertThat(book.isR18(), is(true));
	}

}
