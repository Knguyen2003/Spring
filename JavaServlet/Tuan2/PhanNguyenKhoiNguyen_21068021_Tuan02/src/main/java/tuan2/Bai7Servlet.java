package tuan2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

//@WebServlet("/Bai7Servlet")
@MultipartConfig(
		location = "D:\\LTWWW\\Tuan2\\FolderServerBai7",
		fileSizeThreshold = 1024*1024, //Tức là lớn hơn 1MB thì sẽ được lưu vào địa chỉ đã chỉ định (location) còn nhỏ hơn sẽ lưu trong bộ nhớ tạm
		maxFileSize = 1024*1024*5,  //Kích thước file tối đa là 5MB của mỗi file
		maxRequestSize = 1024*1024*10 //Tổng kích thước của tất cả các tệp trong một lần tải lên không được vượt quá 10MB
)
public class Bai7Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int BUFFER_SIZE = 4096;

    
    private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=bai7;encrypt=false;trustServerCertificate=true";
    private String dbUser = "sa";
    private String dbPass = "sapassword"; 
    
	public Bai7Servlet() {
	}
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init(); //Gọi phương thức init() của lớp cha HttpServlet Điều này đảm bảo rằng các thiết lập từ lớp cha được thực hiện trước khi lớp con thực hiện các thiết lập bổ sung.
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // TODO Auto-generated method stub
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        
        PrintWriter out = response.getWriter();
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
//        	request.setAttribute("Message", "First Name and Last Name are required.");
//            getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
            out.println("First Name and Last Name are required.");
            return;
        }
        
        InputStream inputStream = null;
        Part filePart = request.getPart("photo");
        String fileUploadName = "";
        
//        if (filePart != null && filePart.getSize() > 0) {
//            fileUploadName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            inputStream = filePart.getInputStream();
//        }
        
        if (filePart != null) {
        	 //getSubmittedFileName() trả về tên của file upload
        	 fileUploadName = filePart.getSubmittedFileName(); // filePart.getSize());  //getName() sẽ trả về tên của phần (form field name), không phải tên tệp được tải lên
        	 inputStream = filePart.getInputStream();
        	}

        Connection conn = null;
        String message = null;
        String filePath = "D:/" + fileUploadName + ".jpg";
        try {
        	try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String sql = "INSERT INTO contacts (first_name, last_name, photo) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            } else {
                message = "File upload failed";
            }

            String sql1 = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
            statement = conn.prepareStatement(sql1);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("photo");
                inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
//        request.setAttribute("Message", message);
//        getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
        response.getWriter().println(message);
    } 	
}
