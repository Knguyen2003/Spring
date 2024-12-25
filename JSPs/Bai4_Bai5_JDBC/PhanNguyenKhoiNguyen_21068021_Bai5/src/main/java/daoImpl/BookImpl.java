package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import dao.BookDao;
import entity.Book;

public class BookImpl implements BookDao {
	private DataSource dataSource;

	public BookImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource;
	}

	@Override
	public void addBook(Book book) {
	  String sql = "INSERT INTO book(tieude, anh, gia, soLuong) VALUES (?,?,?,?)";
	  try(
			Connection conn = this.dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getImage());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getSoLuongTon());
			int rows = ps.executeUpdate();
			if(rows == 0) {
                System.out.println("Insert failed");
            }else {
            	 System.out.println("Insert success");
            }
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public void updateBookSoLuong(int id, int soLuong) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Book> getAllBooks() {
		  String sql = "SELECT * FROM book";
		  List<Book> list = new ArrayList<Book>();
		  try(
				Connection conn = this.dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
			) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("tieude");
					String image = rs.getString("anh");
					double price = rs.getDouble("gia");
					int soLuongTon = rs.getInt("soLuong");
					list.add(new Book(id, title, image, price, soLuongTon));
				}
				return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		  return list;
	}

	@Override
	public Book getBookById(int id) {
		String sql = "SELECT * FROM book where id = ?";
		  try(
				Connection conn = this.dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
			) {
			    ps.setInt(1, id);
			    ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int ma = rs.getInt("id");
					String title = rs.getString("tieude");
					String image = rs.getString("anh");
					double price = rs.getDouble("gia");
					int soLuongTon = rs.getInt("soLuong");
					return new Book(ma, title, image, price, soLuongTon);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		  return null;
	}

}
