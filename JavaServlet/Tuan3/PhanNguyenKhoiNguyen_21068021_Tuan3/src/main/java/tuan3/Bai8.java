package tuan3;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/Bai8")
public class Bai8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Bai8() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = "haianhchidan@gmail.com";
        String from = "nguyenphan1122k3@gmail.com";
        String pass = "wawc kqgr yvur vlaz";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587"); //587 là cổng mặc định của SMTP khi sử dụng TLS (khuyến khích hơn), còn 465 là cổng mặc định khi sử dụng SSL
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
        
        
        //Use SSL: Cấu hình máy chủ SMTP và SSL
//        properties.put("mail.smtp.host", "smtp.gmail.com"); // Đặt máy chủ SMTP
//        properties.put("mail.smtp.port", "465"); // Đặt cổng cho SSL
//        properties.put("mail.smtp.auth", "true"); // Bật xác thực
//        properties.put("mail.smtp.socketFactory.port", "465"); // Cấu hình cổng cho SSL
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Sử dụng SSLSocketFactory
//        properties.put("mail.smtp.socketFactory.fallback", "false"); // Không sử dụng fallback
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Tin tưởng vào máy chủ SMTP Gmail


        //Tạo đối tượng Authenticator để xác thực tài khoản
        Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, pass);
			}
        };
        //Phiên làm việc giữa ứng dụng và máy chủ
        Session session = Session.getInstance(properties, authenticator);
        

        try {
        	//MimeMessage là một đối tượng chứa thông tin email, sử dụng để gửi email qua JavaMail
            MimeMessage message = new MimeMessage(session); 
            
            //Thiết lập địa chỉ email, thông tin người gửi, người nhận, tiêu đề và nội dung email
            message.setFrom(new InternetAddress(from)); //Thiết lập người gửi
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); //Thiết lập người nhận
            message.setSubject("Subject Line!"); //Thiết lập tiêu đề email

            //Nội dung email
            BodyPart messageBodyPart = new MimeBodyPart(); //Tạo một đối tượng BodyPart để thiết lập nội dung email
            
            String htmlContent = "<h1>This is the HTML content</h1><p>Here is a paragraph in the email.</p>"; 
            messageBodyPart.setContent(htmlContent, "text/html"); //Thiết lập nội dung email

            //Chứa nhiều phần nội dung email (ví dụ: nội dung text, file đính kèm, hình ảnh, ...)
            Multipart multipart = new MimeMultipart(); //Tạo một đối tượng Multipart để chứa nhiều phần nội dung email (ví dụ: nội dung text, file đính kèm, hình ảnh, ...)
            multipart.addBodyPart(messageBodyPart); //Thêm messageBodyPart vào multipart

            messageBodyPart = new MimeBodyPart(); //Tạo một đối tượng BodyPart để chứa file đính kèm
            String filename = "C:\\Users\\ACER\\OneDrive\\Pictures\\Camera Roll\\ẢNH.jpg"; //Đường dẫn đến file muốn gửi
            DataSource source = new FileDataSource(filename); //DataSource là một đối tượng quản lý dữ liệu file, dùng để thiết lập file đính kèm
            messageBodyPart.setDataHandler(new DataHandler(source)); //DataHandler: Thiết lập file đính kèm
            messageBodyPart.setFileName(filename); //Thiết lập tên file đính kèm
            multipart.addBodyPart(messageBodyPart); //Thêm file đính kèm vào phần nội dung email
            
            message.setContent(multipart); //Thiết lập nội dung chính của email là multipart, chứa cả nội dung chính và file đính kèm.
            
            Transport.send(message); // Gửi mai
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

/*
 * Sử dụng SSL và TLS CÓ GÌ KHÁC NHAU?
 * 1. SSL (Secure Sockets Layer): SSL là một giao thức bảo mật được sử dụng để bảo vệ dữ liệu truyền qua Internet. SSL sử dụng mã hóa để bảo vệ thông tin giữa máy khách và máy chủ.
 * 2. TLS (Transport Layer Security): TLS là phiên bản cải tiến của SSL. TLS cung cấp cùng một cấp độ bảo mật như SSL, nhưng TLS bảo vệ dữ liệu truyền qua Internet tốt hơn. Sử dụng các thuật toán mã hóa mạnh hơn như SHA-256, hỗ trợ nhiều kỹ thuật mã hóa hiện đại, an toàn hơn, như ChaCha20.
 * SSL: Phiên bản cũ, bảo mật thấp, không còn được khuyến nghị.
 * TLS: Phiên bản hiện đại, bảo mật cao, là tiêu chuẩn được sử dụng rộng rãi ngày nay.
 * */
