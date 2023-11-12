package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ResetPass1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNewPass, txtVerify;
	private JButton btnReset;
	public static String email;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ResetPass1(String email) {
		this.email= email;
		initComponents();
	}
	private void initComponents() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Đặt lại mật khẩu");
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

	    JLabel lblNewLabel_1 = new JLabel("WELCOME");
	    lblNewLabel_1.setBounds(72, 25, 174, 37);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	    panel.add(lblNewLabel_1);

	    JLabel lblNewLabel_2 = new JLabel("Karaoke 4T");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_2.setBounds(107, 72, 108, 13);
	    panel.add(lblNewLabel_2);

	    btnReset = new JButton("Reset");
	    btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newPassword = txtNewPass.getText();

		        if (newPassword.equals(txtVerify.getText())) {
		            // Gọi phương thức để cập nhật mật khẩu trong cơ sở dữ liệu
		        	SendEmail1.updatePasswordInDatabase(email, newPassword);
		            JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
		            GD_Login login = new GD_Login();
		            login.setVisible(true);
		            dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
		        }
			}
	        
	    });
	    btnReset.setBounds(44, 329, 239, 40);
	    panel.add(btnReset);
	    btnReset.setForeground(Color.WHITE);
	    btnReset.setBackground(Color.BLACK);
	    btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));

	    JLabel lblNewLabel_4 = new JLabel("New Password");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_4.setBounds(44, 168, 108, 13);
	    panel.add(lblNewLabel_4);

	    JLabel lblNewLabel_4_1 = new JLabel("Verify Password");
	    lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_4_1.setBounds(44, 234, 108, 13);
	    panel.add(lblNewLabel_4_1);

	    txtVerify = new JTextField();
	    txtVerify.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtVerify.setBounds(44, 257, 240, 40);
	    panel.add(txtVerify);

	    txtNewPass = new JTextField();
	    txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txtNewPass.setBounds(44, 191, 240, 40);
	    panel.add(txtNewPass);
	    txtNewPass.setColumns(10);
	    
	    JLabel lblNewLabel_4_2 = new JLabel("Tên tài khoản");
	    lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_4_2.setBounds(43, 95, 108, 13);
	    panel.add(lblNewLabel_4_2);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    textField.setColumns(10);
	    textField.setBounds(43, 118, 240, 40);
	    panel.add(textField);

	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setIcon(new ImageIcon(ResetPass1.class.getResource("/Imgs/BG_login.jpg")));
	    lblNewLabel.setBounds(0, 0, 728, 468);
	    contentPane.add(lblNewLabel);
	}
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResetPass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		ResetPass1 aaa = new ResetPass1(email);
		aaa.setVisible(true);
	}

}
