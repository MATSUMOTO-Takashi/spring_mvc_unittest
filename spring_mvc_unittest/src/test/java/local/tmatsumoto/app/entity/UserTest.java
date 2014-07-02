package local.tmatsumoto.app.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Test;

public class UserTest {
	
	User user = new User();

	@Test
	public void userの年齢が18歳以上ならR18も読める() {
		User user = spy(this.user);
		doReturn(18).when(user).getAge();
		
		Book book = spy(new Book());
		doReturn(true).when(book).isR18();
		
		assertThat(user.canRead(book), is(true));
	}
	
	@Test
	public void userの年齢が18歳未満だとR18は読めない() {
		User user = spy(this.user);
		doReturn(17).when(user).getAge();
		
		Book book = spy(new Book());
		doReturn(true).when(book).isR18();

		assertThat(user.canRead(book), is(false));
	}
	
	@Test
	public void userの年齢に関係なくR18でなければ読める() {
		User user = spy(this.user);
		doReturn(17).when(user).getAge();
		
		Book book = spy(new Book());
		doReturn(false).when(book).isR18();

		assertThat(user.canRead(book), is(true));
	}

}
