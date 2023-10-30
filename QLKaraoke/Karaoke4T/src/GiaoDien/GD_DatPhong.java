package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GD_DatPhong extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DatPhong frame = new GD_DatPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_DatPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
        
        //Giao dien thong tin khach hang`
        JPanel pnl_thongtinkhachhang = new JPanel();
        pnl_thongtinkhachhang.setBackground(new Color(255, 255, 255, 200));
        pnl_thongtinkhachhang.setBounds(0, 148, 329, 463);
        contentPane.add(pnl_thongtinkhachhang);
        pnl_thongtinkhachhang.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(25, 55, 236, 25);
        pnl_thongtinkhachhang.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên Khách Hàng");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(27, 24, 107, 33);
        pnl_thongtinkhachhang.add(lblNewLabel);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBounds(25, 115, 109, 23);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
        rdbtnNewRadioButton_1.setBounds(152, 115, 109, 23);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("Số Điện Thoại");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(25, 164, 93, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(25, 187, 236, 25);
        pnl_thongtinkhachhang.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(25, 238, 236, 25);
        pnl_thongtinkhachhang.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(25, 291, 236, 25);
        pnl_thongtinkhachhang.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("CMND");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(25, 219, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(25, 274, 60, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_3);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(25, 351, 46, 22);
        pnl_thongtinkhachhang.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(129, 351, 46, 22);
        pnl_thongtinkhachhang.add(comboBox_1);
        
        JLabel lblNewLabel_4 = new JLabel("Giờ");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(81, 354, 46, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Phút");
        lblNewLabel_5.setBounds(185, 355, 46, 14);
        pnl_thongtinkhachhang.add(lblNewLabel_5);
        
        JButton btnDatPhong = new JButton("Đặt phòng");
        btnDatPhong.setBackground(new Color(90, 167, 167));
        btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnDatPhong.setBounds(25, 410, 109, 23);
        pnl_thongtinkhachhang.add(btnDatPhong);
        
        JButton btnHuyDatPhong = new JButton("Hủy Đặt");
        btnHuyDatPhong.setBackground(new Color(255, 85, 85));
        btnHuyDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnHuyDatPhong.setBounds(168, 410, 107, 23);
        pnl_thongtinkhachhang.add(btnHuyDatPhong);
		
		JPanel datphong = new JPanel();
		datphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		datphong.setBorder(null);
		datphong.setBackground(new Color(0, 0, 0, 150));
		datphong.setBounds(0, 70, 232, 80);
		contentPane.add(datphong);
		datphong.setLayout(null);
		
		JLabel lbldatphong = new JLabel("Đặt Phòng");
		lbldatphong.setForeground(Color.WHITE);
		lbldatphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldatphong.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatphong.setBounds(0, 0, 232, 80);
		datphong.add(lbldatphong);
		
		//Danh sach phong hat
		
		JPanel pnl_danhsachphonghat = new JPanel();
		pnl_danhsachphonghat.setBackground(new Color(255, 255, 255, 200));
		pnl_danhsachphonghat.setBounds(322, 148, 839, 463);
        contentPane.add(pnl_danhsachphonghat);
        pnl_danhsachphonghat.setLayout(null);
        
        JLabel lblNewLabel_6 = new JLabel("Phòng VIP: 200k/h");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_6.setBounds(258, 11, 163, 28);
        pnl_danhsachphonghat.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Phòng thường: 100k/h");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_7.setBounds(448, 16, 197, 19);
        pnl_danhsachphonghat.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Tầng 1:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_8.setBounds(38, 61, 69, 14);
        pnl_danhsachphonghat.add(lblNewLabel_8);
        
        JButton btnChonPhongHat = new JButton("");
        btnChonPhongHat.setBackground(new Color(168, 168, 168));
        btnChonPhongHat.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat.setBounds(66, 110, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat);
        
        JButton btnChonPhongHat2 = new JButton("");
        btnChonPhongHat2.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat2.setBounds(213, 110, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat2);
        
        JButton btnChonPhongHat3 = new JButton("");
        btnChonPhongHat3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnChonPhongHat3.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat3.setBounds(360, 110, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat3);
        
        JButton btnChonPhongHat4 = new JButton("");
        btnChonPhongHat4.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro_with_crown.png")));
        btnChonPhongHat4.setBounds(518, 110, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat4);
        
        JButton btnChonPhongHat5 = new JButton("");
        btnChonPhongHat5.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat5.setBounds(679, 110, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat5);
        
        JButton btnChonPhongHat6 = new JButton("");
        btnChonPhongHat6.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat6.setBounds(66, 252, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat6);
        
        JButton btnChonPhongHat7 = new JButton("");
        btnChonPhongHat7.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat7.setBounds(213, 252, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat7);
        
        JButton btnChonPhongHat8 = new JButton("");
        btnChonPhongHat8.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat8.setBounds(360, 252, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat8);
        
        JButton btnChonPhongHat9 = new JButton("");
        btnChonPhongHat9.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat9.setBounds(518, 252, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat9);
        
        JButton btnChonPhongHat10 = new JButton("");
        btnChonPhongHat10.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/micro.png")));
        btnChonPhongHat10.setBounds(679, 252, 88, 85);
        pnl_danhsachphonghat.add(btnChonPhongHat10);
        
        JLabel lbl_p101 = new JLabel("P101");
        lbl_p101.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p101.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p101.setBounds(76, 195, 69, 28);
        pnl_danhsachphonghat.add(lbl_p101);
        
        JLabel lbl_p102 = new JLabel("P102");
        lbl_p102.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p102.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p102.setBounds(223, 195, 69, 28);
        pnl_danhsachphonghat.add(lbl_p102);
        
        JLabel lbl_p103 = new JLabel("P103");
        lbl_p103.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p103.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p103.setBounds(370, 195, 69, 28);
        pnl_danhsachphonghat.add(lbl_p103);
        
        JLabel lbl_p104 = new JLabel("P104");
        lbl_p104.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p104.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p104.setBounds(528, 195, 69, 28);
        pnl_danhsachphonghat.add(lbl_p104);
        
        JLabel lbl_p105 = new JLabel("P105");
        lbl_p105.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p105.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p105.setBounds(689, 195, 69, 28);
        pnl_danhsachphonghat.add(lbl_p105);
        
        JLabel lbl_p106 = new JLabel("P106");
        lbl_p106.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p106.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p106.setBounds(76, 337, 69, 28);
        pnl_danhsachphonghat.add(lbl_p106);
        
        JLabel lbl_p107 = new JLabel("P107");
        lbl_p107.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p107.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p107.setBounds(223, 337, 69, 28);
        pnl_danhsachphonghat.add(lbl_p107);
        
        JLabel lbl_p108 = new JLabel("P108");
        lbl_p108.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p108.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p108.setBounds(370, 337, 69, 28);
        pnl_danhsachphonghat.add(lbl_p108);
        
        JLabel lbl_p109 = new JLabel("P109");
        lbl_p109.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p109.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p109.setBounds(528, 337, 69, 28);
        pnl_danhsachphonghat.add(lbl_p109);
        
        JLabel lbl_p1010 = new JLabel("P101");
        lbl_p1010.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_p1010.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl_p1010.setBounds(689, 337, 69, 28);
        pnl_danhsachphonghat.add(lbl_p1010);
        
        JPanel pnl_chuthichdadat = new JPanel();
        pnl_chuthichdadat.setLayout(null);
        pnl_chuthichdadat.setBackground(new Color(128, 128, 128));
        pnl_chuthichdadat.setBounds(413, 426, 32, 26);
        pnl_danhsachphonghat.add(pnl_chuthichdadat);
        
        JLabel lblNewLabel_9 = new JLabel("Phòng trống");
        lblNewLabel_9.setBounds(321, 426, 59, 26);
        pnl_danhsachphonghat.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Phòng đã đặt");
        lblNewLabel_10.setBounds(464, 426, 69, 26);
        pnl_danhsachphonghat.add(lblNewLabel_10);
        
        JPanel pnl_chuthichphongtrong = new JPanel();
        pnl_chuthichphongtrong.setBackground(new Color(255, 255, 255, 200));
        pnl_chuthichphongtrong.setBounds(599, 574, 32, 26);
        contentPane.add(pnl_chuthichphongtrong);
        pnl_chuthichphongtrong.setLayout(null);
        
        
		
		JPanel thuephong = new JPanel();
		thuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thuephong.setLayout(null);
		thuephong.setBorder(null);
		thuephong.setBackground(new Color(0, 0, 0, 150));
		thuephong.setBounds(229, 70, 232, 80);
		contentPane.add(thuephong);
		
		JLabel lblthuephong = new JLabel("Thuê Phòng");
		lblthuephong.setHorizontalAlignment(SwingConstants.CENTER);
		lblthuephong.setForeground(Color.WHITE);
		lblthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthuephong.setBounds(0, 0, 232, 80);
		thuephong.add(lblthuephong);
		
		JPanel datdichvu = new JPanel();
		datdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		datdichvu.setLayout(null);
		datdichvu.setBorder(null);
		datdichvu.setBackground(new Color(0, 0, 0, 150));
		datdichvu.setBounds(462, 70, 232, 80);
		contentPane.add(datdichvu);
		
		JLabel lbltdatdichvu = new JLabel("Đặt Dịch Vụ");
		lbltdatdichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltdatdichvu.setForeground(Color.WHITE);
		lbltdatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltdatdichvu.setBounds(0, 0, 232, 80);
		datdichvu.add(lbltdatdichvu);
		
		JPanel khachhang = new JPanel();
		khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		khachhang.setLayout(null);
		khachhang.setBorder(null);
		khachhang.setBackground(new Color(0, 0, 0, 150));
		khachhang.setBounds(695, 70, 232, 80);
		contentPane.add(khachhang);
		
		JLabel lbltkhachhang = new JLabel("Khách Hàng");
		lbltkhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltkhachhang.setForeground(Color.WHITE);
		lbltkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltkhachhang.setBounds(0, 0, 232, 80);
		khachhang.add(lbltkhachhang);
		
		JPanel thongke = new JPanel();
		thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thongke.setLayout(null);
		thongke.setBorder(null);
		thongke.setBackground(new Color(0, 0, 0, 150));
		thongke.setBounds(928, 70, 233, 80);
		contentPane.add(thongke);
		
		JLabel lblthongke = new JLabel("Thống Kê");
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setForeground(Color.WHITE);
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthongke.setBounds(0, 0, 232, 80);
		thongke.add(lblthongke);
		
		JLabel lb_hinhnen = new JLabel("");
		lb_hinhnen.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/Imgs/370.png")));
		lb_hinhnen.setBounds(-40, -176, 1333, 957);
		contentPane.add(lb_hinhnen);
		
		//Thông tin khách hàng form
//		JLabel lbl_hovaten = new JLabel("Nhập họ và tên");
//		lbl_hovaten.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lbl_hovaten.setBounds(31, 26, 159, 14);
//		lb_hinhnen.add(lbl_hovaten);
		
		
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