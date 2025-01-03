package tuan3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
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


//@WebServlet("/FileUploadDBServlet")
@MultipartConfig(maxFileSize = 16177215) //Nếu người dùng cố gắng tải lên một file có kích thước lớn hơn giá trị này, một ngoại lệ sẽ được ném ra.
public class Bai7 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int BUFFER_SIZE = 4096; // 4KB
    private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB";
    private String dbUser = "sa";
    private String dbPass = "sapassword";

    public Bai7() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName");
        InputStream inputStream = null;  //Dùng để lưu trữ dữ liệu của file tải lên từ client
        Part filePart = request.getPart("photo"); //Đối tượng Part chứa thông tin của file tải lên từ client
        String fileUploadName = ""; //Tên của file tải lên
        String message = ""; //Thông báo trả về cho người dùng
//        System.out.println(filePart);
        if (filePart != null) {
            fileUploadName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); //Lấy tên file //Anh.jpg
            inputStream = filePart.getInputStream(); //Đọc nội dung file tải lên và lưu vào InputStream
            Connection conn = null;

            try {
                // Register the JDBC driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Nạp driver JDBC

                // Establish a connection
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass); //Tạo kết nối tới database
 
                // Prepare SQL statement
                String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                if (inputStream != null) {
                    statement.setBlob(3, inputStream);//nội dung file tải lên được lưu vào cột photo trong database
                }
                //insert là có sự thay đổi
                int row = statement.executeUpdate(); 
                if (row > 0) {
                    message = "File uploaded and saved into database.";
                }

                // Read file back from the database
                String sql1 = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
                statement = conn.prepareStatement(sql1);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                ResultSet result = statement.executeQuery();

                //hiển thị
                if (result.next()) {
                    Blob blob = result.getBlob("photo");
                    inputStream = blob.getBinaryStream(); //Đọc dữ liệu của file từ database và lưu vào InputStream
                    String filePath = "D:\\LTWWW\\Tuan3\\SaveFile\\" + fileUploadName;
                    try (OutputStream outputStream = new FileOutputStream(filePath)) {
                        int bytesRead;
                        byte[] buffer = new byte[BUFFER_SIZE];
                        /*
                         * Mảng byte thường được sử dụng để lưu trữ dữ liệu nhị phân, chẳng hạn như nội dung file hoặc dữ liệu mạng.
                         */
                        while ((bytesRead = inputStream.read(buffer)) != -1) { //Đọc dữ liệu từ InputStream và lưu vào file trên đĩa cứng
                            outputStream.write(buffer, 0, bytesRead);
                        }
                        message = "File uploaded and saved into database and file system successfully.";
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        message = "File uploaded but error while saving file on disk: " + ex.getMessage();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                message = "JDBC Driver not found: " + e.getMessage();
            } catch (SQLException e) {
                e.printStackTrace();
                message = "Database error: " + e.getMessage();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                // Trả về thông báo trực tiếp cho người dùng
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>" + message + "</h2>");
                response.getWriter().println("</body></html>");
            }
        } else {
            message = "No file uploaded.";
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>" + message + "</h2>");
            
            response.getWriter().println("</body></html>");
        }
    }
}

/*
 * location: Đường dẫn đến thư mục tạm thời lưu trữ các file được tải lên.
 *maxRequestSize: Giới hạn kích thước tối đa của toàn bộ request (bao gồm cả form data và các file).
 *fileSizeThreshold: Kích thước tối thiểu của file trước khi nó được lưu tạm thời vào đĩa. Nếu file nhỏ hơn ngưỡng này, nó sẽ được giữ trong bộ nhớ.
 * */
