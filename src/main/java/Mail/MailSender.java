package Mail;
import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
public class MailSender {
    public static void sendEmail(String to, String from, String username, String password, String host, String subject, String content) {
        // Cấu hình Mailtrap
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525"); // Port mặc định của Mailtrap

        // Tạo phiên object
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);
            // Đặt trường From
            message.setFrom(new InternetAddress(from));
            // Đặt trường To
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Đặt tiêu đề email
            message.setSubject(subject);
            // Đặt nội dung email
            message.setText(content);
            // Gửi email
            Transport.send(message);
            System.out.println("Email Message Sent Successfully to " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}


