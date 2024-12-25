package shopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import shopping.dao.ProductDao;
import shopping.entities.Product;

public class ProductDaoImpl implements ProductDao {
	private DataSource dataSource;
	

	public ProductDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> findAll(){
		String sql = "SELECT * FROM product";
		List<Product> list = new ArrayList<Product>();
		try(
			Connection con = this.dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
				){
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double gia = rs.getDouble("price");
				String image = rs.getString("image");
				list.add(new Product(id, name, gia, image));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getProductByID(int id) {
		Product p = null;
		String sql= "SELECT * FROM product where id = ?";
		try(
			Connection con = this.dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setInt(1, id);
			try(ResultSet rs =ps.executeQuery();){
				while(rs.next()) {
					int idMoi = rs.getInt("id");
					String name = rs.getString("name");
					double gia = rs.getDouble("price");
					String image = rs.getString("image");
					p =new Product(idMoi, name, gia, image);
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void addProduct(Product p) {
		String sql = "INSERT INTO product(name, price, image) VALUES(?,?,?)";
        try(
            Connection con = this.dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getImage());
            if(ps.executeUpdate() != 0) {
                System.out.println("Insert success");
            }else {
                System.out.println("Insert fail");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

	}

