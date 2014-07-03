package local.tmatsumoto.app.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User user;
	Book book;
	
	@Before
	public void setUp() {
		user = spy(new User());
		book = spy(new Book());
	}

	@Test
	public void userの年齢が18歳以上ならR18も読める() {
		doReturn(18).when(user).getAge();
		doReturn(true).when(book).isR18();
		
		assertThat(user.canRead(book), is(true));
	}
	
	@Test
	public void userの年齢が18歳未満だとR18は読めない() {
		doReturn(17).when(user).getAge();
		doReturn(true).when(book).isR18();

		assertThat(user.canRead(book), is(false));
	}
	
	@Test
	public void userの年齢に関係なくR18でなければ読める() {
		doReturn(17).when(user).getAge();
		doReturn(false).when(book).isR18();

		assertThat(user.canRead(book), is(true));
	}

}
