package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.GiangVienDao;
import models.GiangVien;

public class GiangVienDaoImpl implements GiangVienDao{
	
	private DataSource dataSource;
	
	public GiangVienDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean themGiangVien(GiangVien giangVien) {
		String sql = "INSERT INTO GIANGVIEN(MAGV, TENGV, LINHVUCNGHIENCUU, SODIENTHOAI) VALUES(?,?,?,?)";
		try(
				Connection conn = dataSource.getConnection();
			    PreparedStatement ps =conn.prepareStatement(sql);
			){
			   ps.setString(1, giangVien.getMaGV());
			   ps.setString(2, giangVien.getTenGV());
			   ps.setString(3, giangVien.getLinhVucNghienCuu());
			   ps.setString(4, giangVien.getSoDienThoai());
			   int kq = ps.executeUpdate();
			   if(kq > 0) {
                   return true;
               }else {
            	  return false;
               }
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
		    return false;
	}

	@Override
	public GiangVien timGiangVienTheoMa(String maGiangVien) {
		String sql = "SELECT * FROM GIANGVIEN WHERE MAGV = ?";
		GiangVien giangVien = null;
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);

		) {
			ps.setString(1, maGiangVien);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String maGV = rs.getString("MAGV");
					String tenGV = rs.getString("TENGV");
					String LVNC = rs.getString("LINHVUCNGHIENCUU");
					String sdt = rs.getString("SODIENTHOAI");
					return new GiangVien(maGV, tenGV, LVNC, sdt);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<GiangVien> layToanBoGiangVien() {
		String sql = "SELECT * FROM GIANGVIEN";
		List<GiangVien> dsGiangVien = new ArrayList<>();
		try(
			Connection conn = dataSource.getConnection();
		    PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	
		){
			while (rs.next()) {
			    String maGV = rs.getString("MAGV");
			    String tenGV = rs.getString("TENGV");
			    String LVNC = rs.getString("LINHVUCNGHIENCUU");
			    String sdt = rs.getString("SODIENTHOAI");
				dsGiangVien.add(new GiangVien(maGV, tenGV, LVNC, sdt));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return dsGiangVien;
	}

}
