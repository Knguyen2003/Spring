package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.CartDao;
import entity.CartItem;
import entity.Order;

public class CartDaoImpl implements CartDao{

	private DataSource dataSource;
	
	public CartDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveCart(CartItem cart) {
		String sql = "INSERT INTO cart (bookId, quantity,orderID) VALUES (?,?,?)";
		try(
            Connection con = this.dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setInt(1, cart.getBook().getId());
            pst.setInt(2, cart.getQuantity());  
            pst.setInt(3, cart.getOrderId());  
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
		
	   }
	}
	
	
	@Override
	public void saveOrder(Order o) {
		String sql = "INSERT INTO orders (fullName,address,total,payMent) VALUES (?,?,?,?)";
		try(
            Connection con = this.dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setString(1, o.getFullName());  
            pst.setString(2, o.getAddress());  
            pst.setDouble(3, o.getToTal());  
            pst.setInt(4, o.getPayment());  
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
		
	   }
	}

	@Override
	public int getOrderId() {
		String sql = "SELECT TOP 1 orderID FROM orders ORDER BY orderID DESC;";
		try(
            Connection con = this.dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            ResultSet rs =  pst.executeQuery();
            while(rs.next()) {
                return rs.getInt("orderID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
		
	   }
		return 0;
	}
}
