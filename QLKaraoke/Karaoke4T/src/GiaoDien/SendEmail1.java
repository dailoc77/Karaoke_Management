package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.AddressException;



public class SendEmail1 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail, txtCode;
	private JButton btnSend;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	final static String from = "karaoke4t@gmail.com";
	final static String password = "koeblhszjuoqrenq";
	static int randomCode;
//	String to = "maiqtruong2403@gmail.com";
	String[] to = {"maiqtruong2403@gmail.com", "truongdailoc2003@gmail.com", "thachgpt@gmail.com", "duongphan1912@gmail.com"};
	
	public SendEmail1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Đăng nhập");
		setBounds(100, 100, 734, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JPanel panel = new JPanel();
	    panel.setForeground(new Color(255, 255, 255));
	    panel.setBackground(new Color(255, 255, 255, 200));
	    panel.setBounds(201, 36, 323, 379);
	    contentPane.add(panel);
	    panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELLCOME");
		lblNewLabel_1.setBounds(72, 25, 174, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Karaoke 4T");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(107, 72, 108, 13);
		panel.add(lblNewLabel_2);
		
		btnSend = new JButton("Send Email");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText().trim();
                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an email address.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    sendEmail(email, password, from);
                }
			}
		});
		btnSend.setBounds(132, 174, 151, 23);
		panel.add(btnSend);
		btnSend.setForeground(Color.WHITE);
		btnSend.setBackground(Color.BLACK);
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnSend.addActionListener(this);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblemail.setBounds(44, 101, 64, 13);
		panel.add(lblemail);
		
		JLabel lblcode = new JLabel("Verify Code");
		lblcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcode.setBounds(44, 203, 97, 13);
		panel.add(lblcode);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(44, 124, 239, 40);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCode.setColumns(10);
		txtCode.setBounds(44, 224, 239, 40);
		panel.add(txtCode);
		
		JButton btnVerifyCode = new JButton("Verify Code");
		btnVerifyCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int userEnteredCode = Integer.parseInt(txtCode.getText());

		            if (userEnteredCode == randomCode) {
		                // Mở giao diện Reset và chuyển thông tin cần thiết
		                ResetPass1 resetFrame = new ResetPass1(txtEmail.getText());
		                resetFrame.setVisible(true);
		                dispose();  // Đóng cửa sổ SendEmail
		            } else {
		                JOptionPane.showMessageDialog(null, "Mã xác minh không đúng");		          
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập một mã số hợp lệ");
		        }
			}
		});
		btnVerifyCode.setForeground(Color.WHITE);
		btnVerifyCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerifyCode.setBackground(Color.BLACK);
		btnVerifyCode.setBounds(132, 274, 151, 23);
		panel.add(btnVerifyCode);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SendEmail1.class.getResource("/Imgs/BG_login.jpg")));
		lblNewLabel.setBounds(0, 0, 728, 468);
		contentPane.add(lblNewLabel);
	}
	
	public static boolean sendEmail(String to, String tieuDe, String noiDung) {
		// Properties : khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};

		// Phiên làm việc
		Session session = Session.getInstance(props, auth);

		// Tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);

		try {
			Random rand = new Random();
			randomCode = rand.nextInt(999999);
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Người gửi
			msg.setFrom(new InternetAddress(from));

			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Tiêu đề email
			msg.setSubject("Ma xac minh");

			// Quy đinh ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hồi
			// msg.setReplyTo(InternetAddress.parse(from, false))

			// Nội dung
			msg.setContent(noiDung, "text/HTML; charset=UTF-8"); 
			msg.setText("Ma reset code is "+randomCode);
			//String message = "Your reset code is "+randomCode;
			// "Ma reset cod is "+randomCode

			// Gửi email
			Transport.send(msg);
            
			System.out.println("Gửi email thành công");
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}	
	
	public static void main(String[] args) {
		String[] to = {"maiqtruong2403@gmail.com", "truongdailoc2003@gmail.com", "thachgpt@gmail.com", "duongphan1912@gmail.com"};
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SendEmail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendEmail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendEmail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendEmail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		SendEmail1 run = new SendEmail1();
		run.setVisible(true);
		for (int i = 0; i < 0; i++) {	
			SendEmail1.sendEmail(to[i], System.currentTimeMillis() + "", "Ma reset code is "+randomCode);
		}
	
	}

	public static void updatePasswordInDatabase(String email, String newPassword) {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Karaoke4T;user=sa;password=123");

//	        String updateQuery = "UPDATE forgotpassjava SET password=? WHERE email=?";
	        String updateQuery = "UPDATE TaiKhoan SET MK=? WHERE email=?";
	        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	            updateStatement.setString(1, newPassword);
	            updateStatement.setString(2, email);

	            updateStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
