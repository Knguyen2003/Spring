package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import dao.DanhMucDao;
import models.DanhMuc;

public class DanhMucDaoImpl implements DanhMucDao {
	private DataSource dataSource;

	public DanhMucDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<DanhMuc> getAllDanhMuc() {
		String sql = "SELECT * FROM DANHMUC";
		List<DanhMuc> danhMucList = null;
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
		) {
			while (rs.next()) {
				String maDanhMuc = rs.getString("MADM");
				String tenDanhMuc = rs.getString("TENDANHMUC");
				String nguoiQuanLi = rs.getString("NGUOIQUANLY");
				String ghiChu = rs.getString("GHICHU");
				
				DanhMuc danhMuc = new DanhMuc(maDanhMuc, tenDanhMuc, nguoiQuanLi, ghiChu);
				danhMucList.add(danhMuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhMucList;
	}

}
