package GiaoDien;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import testbutton.Buttontest;

public class GD_TraPhong extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private testbutton.Buttontest btnthuephong, btnhuyphong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TraPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_TraPhong frame = new GD_TraPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	/**
	 * Create the frame.
	 */
	public GD_TraPhong (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao Diện Trả Phòng");
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		 Ho tro -----------------------
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://thach1311.github.io/huongDan/").toURI());
				}
				catch(Exception ex){}
			}
		});
		btnNewButton.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/iconHoTro.png")));
		btnNewButton.setBounds(304, 10, 49, 50);
		contentPane.add(btnNewButton);
		
//		------------------------------------------
		JLabel lblquanly = new JLabel("NV:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn C");
		lbltenql.setForeground(Color.WHITE);
		lbltenql.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltenql.setBounds(833, 6, 232, 80);
		contentPane.add(lbltenql);
		
		JButton jButton = new JButton("Đăng Xuất");
		jButton.setBounds(980, 13, 135, 42);
		jButton.setFont(new Font("Tahoma ", Font.BOLD, 14));
		jButton.setBackground(new Color(255, 0, 0));
		jButton.setForeground(Color.WHITE);
		
		jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        jButton.setContentAreaFilled(false);
        jButton.setFocusPainted(false);
        jButton.setOpaque(true);
		contentPane.add(jButton);

		jButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        jButton.setBackground(Color.BLACK);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        jButton.setBackground(new Color(255, 0, 0));
		    }
		});

		jButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            GD_Login lg = new GD_Login();
		            lg.setVisible(true);
		            lg.setLocationRelativeTo(null);
		            dispose();
		        }
		    }
		});
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
		JPanel box_clock = new JPanel();
        box_clock.setBackground(new Color(255, 255, 255));
        box_clock.setBounds(34, 10, 260, 50);
        contentPane.add(box_clock);
        box_clock.setLayout(null);

        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClock.setBounds(10, 0, 240, 50);
        lblClock.setForeground(Color.BLACK);
        box_clock.add(lblClock);

        timer = new Timer(0,this);
        timer.start();
		
		//Danh sach phong hat
		
		JPanel pnl_danhsachphonghat = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		pnl_danhsachphonghat.setBackground(new Color(255, 255, 255, 200));
		pnl_danhsachphonghat.setBounds(0, 148, 1170, 463);
		pnl_danhsachphonghat.setOpaque(false);
        contentPane.add(pnl_danhsachphonghat);
        pnl_danhsachphonghat.setLayout(null);
        
        
        JLabel lblNewLabel_8 = new JLabel("Tầng 1:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_8.setBounds(56, 62, 116, 28);
        pnl_danhsachphonghat.add(lblNewLabel_8);
        
        //button
        
        JButton btnChonPhongHat = new JButton();
        btnChonPhongHat.setText("");
        btnChonPhongHat.setBackground(new Color(168, 168, 168));
        btnChonPhongHat.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat.setBounds(228, 111, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat);
        
        JButton btnChonPhongHat2 = new JButton("");
        btnChonPhongHat2.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat2.setBounds(375, 111, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat2);
        
        JButton btnChonPhongHat3 = new JButton("");
        btnChonPhongHat3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnChonPhongHat3.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat3.setBounds(522, 111, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat3);
        
        JButton btnChonPhongHat4 = new JButton("");
        btnChonPhongHat4.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro_with_crown.png")));
        btnChonPhongHat4.setBounds(680, 111, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat4);
        
        JButton btnChonPhongHat5 = new JButton("");
        btnChonPhongHat5.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat5.setBounds(841, 111, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat5);
        
        JButton btnChonPhongHat6 = new JButton("");
        btnChonPhongHat6.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat6.setBounds(228, 253, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat6);
        
        JButton btnChonPhongHat7 = new JButton("");
        btnChonPhongHat7.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat7.setBounds(375, 253, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat7);
        
        JButton btnChonPhongHat8 = new JButton("");
        btnChonPhongHat8.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat8.setBounds(522, 253, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat8);
        
        JButton btnChonPhongHat9 = new JButton("");
        btnChonPhongHat9.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat9.setBounds(680, 253, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat9);
        
        JButton btnChonPhongHat10 = new JButton("");
        btnChonPhongHat10.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat10.setBounds(841, 253, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat10);
        
        JLabel lbl_p101 = new JLabel("P101");
        lbl_p101.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p101.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p101.setBounds(238, 196, 69, 28);
        pnl_danhsachphonghat.add(lbl_p101);
        
        JLabel lbl_p102 = new JLabel("P102");
        lbl_p102.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p102.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p102.setBounds(385, 196, 69, 28);
        pnl_danhsachphonghat.add(lbl_p102);
        
        JLabel lbl_p103 = new JLabel("P103");
        lbl_p103.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p103.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p103.setBounds(532, 196, 69, 28);
        pnl_danhsachphonghat.add(lbl_p103);
        
        JLabel lbl_p104 = new JLabel("P104");
        lbl_p104.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p104.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p104.setBounds(690, 196, 69, 28);
        pnl_danhsachphonghat.add(lbl_p104);
        
        JLabel lbl_p105 = new JLabel("P105");
        lbl_p105.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p105.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p105.setBounds(851, 196, 69, 28);
        pnl_danhsachphonghat.add(lbl_p105);
        
        JLabel lbl_p106 = new JLabel("P106");
        lbl_p106.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p106.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p106.setBounds(238, 338, 69, 28);
        pnl_danhsachphonghat.add(lbl_p106);
        
        JLabel lbl_p107 = new JLabel("P107");
        lbl_p107.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p107.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p107.setBounds(385, 338, 69, 28);
        pnl_danhsachphonghat.add(lbl_p107);
        
        JLabel lbl_p108 = new JLabel("P108");
        lbl_p108.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p108.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p108.setBounds(532, 338, 69, 28);
        pnl_danhsachphonghat.add(lbl_p108);
        
        JLabel lbl_p109 = new JLabel("P109");
        lbl_p109.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p109.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p109.setBounds(690, 338, 69, 28);
        pnl_danhsachphonghat.add(lbl_p109);
        
        JLabel lbl_p1010 = new JLabel("P101");
        lbl_p1010.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p1010.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p1010.setBounds(851, 338, 69, 28);
        pnl_danhsachphonghat.add(lbl_p1010);
 
        testbutton.Buttontest btndatphong1 = new testbutton.Buttontest();
        btndatphong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong gddatphong = new GD_DatPhong();
				gddatphong.setVisible(true);
				dispose();
			}
		});
        btndatphong1.setBorder(null);
        btndatphong1.setText("Đặt Phòng");
        btndatphong1.setForeground(Color.WHITE);
        btndatphong1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatphong1.setBackground(new Color(0,0,0, 150));
        btndatphong1.setBounds(0, 70, 199, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
        
        testbutton.Buttontest btnthuephong = new testbutton.Buttontest();
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThuePhong gdthuephong = new GD_ThuePhong();
				gdthuephong.setVisible(true);
				dispose();
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(0,0,0, 150));
        btnthuephong.setBounds(195, 70, 196, 87);
		contentPane.add(btnthuephong);
		btnthuephong.setLayout(null);
		
        testbutton.Buttontest btndatdichvu = new testbutton.Buttontest();
        btndatdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatDichVu gddv = new GD_DatDichVu();
				gddv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddv.setVisible(true);
				dispose();
			}
		});
        btndatdichvu.setBorder(null);
        btndatdichvu.setText("Đặt Dịch Vụ");
        btndatdichvu.setForeground(Color.WHITE);
        btndatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatdichvu.setBackground(new Color(0, 0, 0, 150));
        btndatdichvu.setBounds(385, 70, 196, 87);
		contentPane.add(btndatdichvu);
		btndatdichvu.setLayout(null);
        
        testbutton.Buttontest btntstTrPhng = new testbutton.Buttontest();
        btntstTrPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        btntstTrPhng.setBorder(null);
        btntstTrPhng.setText("Trả Phòng");
        btntstTrPhng.setForeground(Color.WHITE);
        btntstTrPhng.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntstTrPhng.setBackground(new Color(128, 128, 128, 150));
        btntstTrPhng.setBounds(577, 70, 196, 87);
        contentPane.add(btntstTrPhng);
        btntstTrPhng.setLayout(null);
        
        testbutton.Buttontest btnkhachhang = new testbutton.Buttontest();
        btnkhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QuanLyKhachHang gdqlykhachhang = new GD_QuanLyKhachHang();
				gdqlykhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqlykhachhang.setVisible(true);
				dispose();
			}
		});
        btnkhachhang.setBorder(null);
        btnkhachhang.setText("Khách Hàng");
        btnkhachhang.setForeground(Color.WHITE);
        btnkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnkhachhang.setBackground(new Color(0, 0, 0, 150));
        btnkhachhang.setBounds(770, 70, 196, 87);
		contentPane.add(btnkhachhang);
		btnkhachhang.setLayout(null);
		
        testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThongKeKhachHang thongkekhachhang = new GD_ThongKeKhachHang();
				thongkekhachhang.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				thongkekhachhang.setVisible(true);
				dispose();
			}
		});
        btnthongke.setBorder(null);
        btnthongke.setText("Thống Kê");
        btnthongke.setForeground(Color.WHITE);
        btnthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthongke.setBackground(new Color(0, 0, 0, 150));
        btnthongke.setBounds(963, 70, 196, 87);
		contentPane.add(btnthongke);
		btnthongke.setLayout(null);
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
    private void updateClock() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        
        String ampm;
        if (hour >= 12) {
            ampm = "PM";
            if (hour > 24) {
                hour -= 12;
            }
        } else {
            ampm = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }
        
        String time = String.format("%02d:%02d:%02d %s  %04d/%02d/%02d", hour, minute, second, ampm, year, month, day);
        lblClock.setText(time);
	}
}
