import java.io.Serializable;

public class Book implements Serializable {
	
	public static final long serialVersionUID = 1l;
	private static SessionIdentifierGenerator GENERATOR = new SessionIdentifierGenerator();
	
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int numberOfPages;
	private String year;
	private String ISBN = GENERATOR.nextSessionId();
	
	
	public Book(String bookTitle, String bookAuthor, String bookGenre, int numberOfPages, String year){
		setTitle(bookTitle);
		setAuthor(bookAuthor);
		setGenre(bookGenre);
		setPages(numberOfPages);
		setYear(year);
		setISBN(ISBN);
	}
	public void setTitle(String bookTitle){
//		if(bookTitle.matches("^[A-Za-z]+{2-25}")){
			this.bookTitle = bookTitle;
//		}
	}
	public void setAuthor(String bookAuthor){
//		if(bookAuthor.matches("^[A-Za-z]+{2-25}")){
			this.bookAuthor = bookAuthor;
//		}
	}
	public void setGenre(String bookGenre){
//		if(bookGenre.matches("^[A-Za-z]+{2-25}")){
			this.bookGenre = bookGenre;
//		}
	}
	public void setPages(int bookPages){
		if(bookPages > 0){
			this.numberOfPages = bookPages;
		}
	}
	public void setYear(String year){
//		if(year.matches("[1500 - 2016]+{4}")){
			this.year = year;
//		}
	}
	
	public void setISBN(String ISBN){
			this.ISBN = ISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public String getYear() {
		return year;
	}
	public String getISBN() {
		return ISBN;
	}
	@Override
	public String toString(){
		return bookTitle + "***" + bookAuthor + "***" + bookGenre + "***" + numberOfPages + "***" + year + "***" + ISBN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookGenre == null) ? 0 : bookGenre.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + numberOfPages;
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookGenre == null) {
			if (other.bookGenre != null)
				return false;
		} else if (!bookGenre.equals(other.bookGenre))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	
	
}
