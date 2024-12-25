package dao;

import java.util.List;

import entity.Book;

public interface BookDao {
	public void addBook(Book book);
	public void updateBookSoLuong(int id,int soLuong);
	public void deleteBook(int id);
    public List<Book> getAllBooks();
    public Book getBookById(int id);

}
