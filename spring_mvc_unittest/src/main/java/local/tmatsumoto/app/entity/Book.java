package local.tmatsumoto.app.entity;

public class Book {

	private String id;
	private String name;
	private String author;
	private Integer targetAge;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getTargetAge() {
		return targetAge;
	}

	public void setTargetAge(Integer targetAge) {
		this.targetAge = targetAge;
	}

	/**
	 * この書籍の対象年齢が18歳以上の場合trueを返します。
	 * 
	 * @return {@link #getTargetAge()} {@code >= 18}の場合true
	 */
	public boolean isR18() {
		return targetAge != null && targetAge >= 18;
	}

}
