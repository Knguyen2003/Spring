package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DeTaiDao;
import models.DeTai;
import models.GiangVien;

public class DeTaiDaoImpl implements DeTaiDao {

	private DataSource dataSource;

	public DeTaiDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean themDeTai(DeTai deTai) {
		String sql = "INSERT INTO DETAI(MADT, TENDT, NAMDANGKY, MOTADETAI, MAGV) VALUES(?,?,?,?,?)";
		try(
				Connection conn = dataSource.getConnection();
			    PreparedStatement ps =conn.prepareStatement(sql);
			){
			   ps.setString(1, deTai.getMaDeTai());
			   ps.setString(2, deTai.getTenDeTai());
			   ps.setInt(3, deTai.getNamDangky());
			   ps.setString(4, deTai.getMoTa());
			   ps.setString(5, deTai.getMaGiangVien().getMaGV());
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
	public List<DeTai> timDeTaiTheoGiangVien(String maGiangVien) {
		String sql = "SELECT * FROM DETAI WHERE MAGV = ?";
		List<DeTai> dsDeTai = new ArrayList<>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);

		) {
			ps.setString(1, maGiangVien);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String maDT = rs.getString("MADT");
					String tenDT = rs.getString("TENDT");
					int nam = rs.getInt("NAMDANGKY");
					String moTa = rs.getString("MOTADETAI");
					dsDeTai.add(new DeTai(maDT, tenDT, nam, moTa));
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDeTai;
	}

	@Override
	public DeTai timDeTaiTheoMaDeTai(String maDeTai) {
		String sql = "SELECT * FROM DETAI WHERE MADT = ?";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);

		) {
			ps.setString(1, maDeTai);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String maDT = rs.getString("MADT");
					String tenDT = rs.getString("TENDT");
					int nam = rs.getInt("NAMDANGKY");
					String moTa = rs.getString("MOTADETAI");
					return new DeTai(maDT, tenDT, nam, moTa);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}



}
