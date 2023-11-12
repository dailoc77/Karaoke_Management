package GiaoDien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class GD_Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser, txtMk;
	private JPasswordField passMk;
	private testbutton.Buttontest btnDangNhap;
	private JLabel lblNewLabel_3;
	public String user;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
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
		
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255, 200));
		panel.setBounds(201, 80, 323, 324);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("WELLCOME");
		lblNewLabel_1.setBounds(72, 25, 174, 37);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Karaoke 4T");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(107, 72, 118, 17);
		panel.add(lblNewLabel_2);
		
		btnDangNhap = new testbutton.Buttontest();
		btnDangNhap.setText("Đăng Nhập");
//		btnDangNhap.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        String query = "select * from TaiKhoan where tenTK = ? and MK = ?";
//		        try {
//		            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T;user=sa;password=123");
//		            pst = con.prepareStatement(query);
//		            pst.setString(1, txtUser.getText());
//		            pst.setString(2, passMk.getText());
//		            rs = pst.executeQuery();
//		            
//		            if (rs.next()) {
//		                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
//
//		                // Kiểm tra xem tài khoản có phải là admin hay không
//		                if (isAdmin(txtUser.getText())) {
//		                    // Nếu là admin, mở giao diện quản lý
//		                    openAdminMain();
//		                } else {
//		                    // Nếu không phải admin, mở giao diện nhân viên
//		                    openEmployeeMain();
//		                }
//		            } else {
//		                JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu sai");
//		            }
//		        } catch (SQLException ex) {
//		            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		        }
//		    }
//		});
		btnDangNhap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if username and password are not empty
		        if (txtUser.getText().trim().isEmpty() || passMk.getPassword().length == 0) {
		            JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản và mật khẩu.");
		            return; // Exit the method if fields are empty
		        }

		        String query = "select * from TaiKhoan where tenTK = ? and MK = ?";
		        try {
		            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T;user=sa;password=123");
		            pst = con.prepareStatement(query);
		            pst.setString(1, txtUser.getText());
		            pst.setString(2, new String(passMk.getPassword())); // Convert password to String
		            rs = pst.executeQuery();

		            if (rs.next()) {
		                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

		                // Kiểm tra xem tài khoản có phải là admin hay không
		                if (isAdmin(txtUser.getText())) {
		                    // Nếu là admin, mở giao diện quản lý
		                    openAdminMain();
		                } else {
		                    // Nếu không phải admin, mở giao diện nhân viên
		                    openEmployeeMain();
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu sai");
		            }
		        } catch (SQLException ex) {
		            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
		    }
		});

		btnDangNhap.setBounds(44, 274, 239, 40);
		panel.add(btnDangNhap);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBackground(Color.BLACK);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		lblNewLabel_3 = new JLabel("Quên Mật Khẩu?");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SendEmail1 sc = new SendEmail1();
				sc.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(162, 241, 131, 17);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tài Khoản");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(44, 101, 64, 17);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mật Khẩu");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(44, 167, 64, 17);
		panel.add(lblNewLabel_4_1);
		
		passMk = new JPasswordField();
		passMk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passMk.setBounds(44, 190, 240, 40);
		panel.add(passMk);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setBounds(44, 124, 240, 40);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GD_Login.class.getResource("/Imgs/BG_login.jpg")));
		lblNewLabel.setBounds(0, 0, 728, 468);
		contentPane.add(lblNewLabel);
		
	}
	protected void openEmployeeMain() {
		// TODO Auto-generated method stub
		GD_Main_NV employeeMain = new GD_Main_NV();
	    employeeMain.setVisible(true);
	    dispose(); // Đóng cửa sổ đăng nhập sau khi đăng nhập thành công
	}
	protected void openAdminMain() {
		// TODO Auto-generated method stub
		GD_Main_QL adminMain = new GD_Main_QL();
	    adminMain.setVisible(true);
	    dispose(); // Đóng cửa sổ đăng nhập sau khi đăng nhập thành công
	}
	private boolean isAdmin(String text) {
		// TODO Auto-generated method stub
		return text.equals("admin");
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
            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		GD_Login run = new GD_Login();
		run.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
