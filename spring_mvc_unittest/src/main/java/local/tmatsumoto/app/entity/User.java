package local.tmatsumoto.app.entity;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		// TODO: 誕生日から年齢を計算するロジックを実装する
		return 0;
	}

	/**
	 * 指定された書籍を読める場合trueを返します。
	 * 
	 * @param book 書籍
	 * @return 読める場合true
	 */
	public boolean canRead(Book book) {
		if (book.isR18()) {
			return getAge() >= 18;
		} else {
			return true;
		}
	}
}
