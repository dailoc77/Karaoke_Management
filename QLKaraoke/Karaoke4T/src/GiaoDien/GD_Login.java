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
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class GD_Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnDangNhap;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GD_Login() {
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
		panel.setBounds(201, 80, 323, 324);
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
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBounds(44, 274, 239, 40);
		panel.add(btnDangNhap);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBackground(Color.BLACK);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangNhap.addActionListener(this);
		
		
		JLabel lblNewLabel_3 = new JLabel("Quên Mật Khẩu?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(162, 238, 121, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tài Khoản");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(44, 101, 64, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mật Khẩu");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(44, 167, 64, 13);
		panel.add(lblNewLabel_4_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(44, 190, 240, 40);
		panel.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(44, 124, 240, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GD_Login.class.getResource("/Imgs/BG_login.jpg")));
		lblNewLabel.setBounds(0, 0, 728, 468);
		contentPane.add(lblNewLabel);

	
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnDangNhap)) {
				if(textField.getText().equals("")){
		            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập tài khoản");
		        } else if(passwordField.getText().equals("")){
		            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập mật khẩu");
		        } else if(textField.getText().equals("admin")){
		                if(passwordField.getText().equals("123")){
		                        GD_Main_NV mng =new GD_Main_NV();
		                        mng.setVisible(true);
		                        this.setVisible(false);
		                }
		                else{
		                    JOptionPane.showMessageDialog(this, "sai mật khẩu");
		                }
		        }else{
		            JOptionPane.showMessageDialog(this, "đăng nhập thất bại");
		        }
			}
	        
		}
	public static void main(String[] args) {
		GD_Login run = new GD_Login();
		run.setVisible(true);
	}

}
