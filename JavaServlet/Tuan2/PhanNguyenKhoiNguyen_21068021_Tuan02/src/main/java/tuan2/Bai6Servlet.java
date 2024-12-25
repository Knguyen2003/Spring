package tuan2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


//@WebServlet("/Bai6Servlet")
@MultipartConfig(
		location = "D:\\LTWWW\\Tuan2\\FolderServerBai6",
		fileSizeThreshold = 1024*1024, //Tức là lớn hơn 1MB thì sẽ được lưu vào địa chỉ đã chỉ định (location) còn nhỏ hơn sẽ lưu trong bộ nhớ tạm
		maxFileSize = 1024*1024*5,  //Kích thước file tối đa là 5MB của mỗi file
		maxRequestSize = 1024*1024*10 //Tổng kích thước của tất cả các tệp trong một lần tải lên không được vượt quá 10MB
)
public class Bai6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String upLoadPath = null;
   
    public Bai6Servlet() {
        
    }
    //Phương thức được gọi mỗi khi Servlet được khởi tạo
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init(); //Gọi phương thức init() của lớp cha HttpServlet Điều này đảm bảo rằng các thiết lập từ lớp cha được thực hiện trước khi lớp con thực hiện các thiết lập bổ sung.
		upLoadPath = getServletContext().getInitParameter("upload.path"); //Lấy đường dẫn từ web.xml
		File uploadDir = new File(upLoadPath); //Tạo thư mục lưu file
		if (!uploadDir.exists()) { //Kiểm tra thư mục đã tồn tại chưa
			uploadDir.mkdir(); //Nếu chưa thì tạo mới
		}
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request lấy thông tin từ người dùng gửi lên
		//response trả về thông tin cho người dùng
		try {
			for (Part filePart : request.getParts()) { 
				if (filePart == null || filePart.getSubmittedFileName() == null || filePart.getSubmittedFileName().isEmpty()) {
					continue;
				}
				String fileName = filePart.getSubmittedFileName();
				//getSubmittedFileName() trả về tên của file mà người dùng đã upload
				
				//Cach 1:
//				filePart.write(fileName);
				
				//Cach 2:
				InputStream inputStream = filePart.getInputStream(); //Lấy dữ liệu từ filePart
				Files.copy(inputStream, Paths.get(upLoadPath + File.separator + fileName),
						StandardCopyOption.REPLACE_EXISTING);
				//Paths.get() taọ một đối tượng Path (đường dẫn) từ một chuỗi đường dẫn
				//StandardCopyOption.REPLACE_EXISTING: Để ghi đè file nếu file đã tồn tại
				//File.separator: Dấu phân cách giữa các thư mục của hệ điều hành
				
				System.out.println(upLoadPath + File.separator + fileName);//In ra đường dẫn file đã upload

				
			}
			response.getWriter().println("Upload file thanh cong"); //In ra thông báo upload file thành công
		} catch (Exception e) {
			response.getWriter().println("File upload failed due to an error:" + e.getMessage()); //In ra thông báo upload file thất bại	
		}
	}

}
