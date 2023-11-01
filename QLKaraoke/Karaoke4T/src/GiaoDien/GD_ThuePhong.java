package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class GD_ThuePhong extends JFrame implements ActionListener {

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
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThuePhong frame = new GD_ThuePhong();
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
	public GD_ThuePhong (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao Diện Thuê Phòng");
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
        JPanel pnl_thongtinkhachhang = new JPanel() {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        pnl_thongtinkhachhang.setOpaque(false);
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
        
        // rad button
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBounds(25, 115, 109, 23);
        rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.setContentAreaFilled(false);
		rdbtnNewRadioButton.setFocusPainted(false);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
        rdbtnNewRadioButton_1.setBounds(152, 115, 109, 23);
        rdbtnNewRadioButton_1.setOpaque(false);
        pnl_thongtinkhachhang.add(rdbtnNewRadioButton_1);
        
        ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		pnl_thongtinkhachhang.add(rdbtnNewRadioButton);pnl_thongtinkhachhang.add(rdbtnNewRadioButton_1);
		// rad button
		 
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
        comboBox.setBounds(25, 362, 53, 22);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        		, "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",}));
        pnl_thongtinkhachhang.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(129, 362, 53, 22);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        		, "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25", "26", "27", "28", "29", "30",
        		"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
        		"41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
        		"51", "52", "53", "54", "55", "56", "57", "58", "59", "60",}));
        pnl_thongtinkhachhang.add(comboBox_1);
        
        JLabel lblNewLabel_4 = new JLabel("Giờ");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(81, 362, 46, 22);
        pnl_thongtinkhachhang.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Phút");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(185, 362, 46, 22);
        pnl_thongtinkhachhang.add(lblNewLabel_5);
        
        //button thue phong
        btnthuephong = new testbutton.Buttontest();
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(new Color(245,245,245));
        btnthuephong.setBackground(new Color(90, 167, 167));
        btnthuephong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnthuephong.setRippleColor(new Color(255, 255, 255));
        btnthuephong.setShadowColor(new Color(0,0,0));
        btnthuephong.setBounds(25, 410, 109, 43);
        pnl_thongtinkhachhang.add(btnthuephong);
        
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhieuDatPhong phieuDatPhong = new GD_PhieuDatPhong();
				phieuDatPhong.setVisible(true);
				phieuDatPhong.setLocationRelativeTo(null);
	            dispose();
			}
		});
        // button huy thue phong
        btnhuyphong = new testbutton.Buttontest();
        btnhuyphong.setText("Hủy Phòng");
        btnhuyphong.setForeground(new Color(245,245,245));
        btnhuyphong.setBackground(new Color(255, 85, 85));
        btnhuyphong.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnhuyphong.setBounds(168, 410, 109, 43);
        btnhuyphong.setRippleColor(new Color(255, 255, 255));
        btnhuyphong.setShadowColor(new Color(0,0,0));
        pnl_thongtinkhachhang.add(btnhuyphong);
        
        JLabel lblNewLabel_3_1 = new JLabel("Giờ nhận phòng\r\n");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1.setBounds(25, 327, 93, 25);
        pnl_thongtinkhachhang.add(lblNewLabel_3_1);
		
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
        btndatphong1.setBounds(0, 70, 232, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
		
		//Danh sach phong hat
		
		JPanel pnl_danhsachphonghat = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		pnl_danhsachphonghat.setBackground(new Color(255, 255, 255, 200));
		pnl_danhsachphonghat.setBounds(322, 148, 839, 463);
		pnl_danhsachphonghat.setOpaque(false);
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
        lblNewLabel_8.setBounds(38, 61, 88, 28);
        pnl_danhsachphonghat.add(lblNewLabel_8);
        
        //button
        JButton btnChonPhongHat = new JButton();
        btnChonPhongHat.setText("");
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
        lblNewLabel_9.setBounds(321, 426, 93, 26);
        pnl_danhsachphonghat.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Phòng đã đặt");
        lblNewLabel_10.setBounds(464, 426, 93, 26);
        pnl_danhsachphonghat.add(lblNewLabel_10);
        
        JPanel pnl_chuthichphongtrong = new JPanel();
        pnl_chuthichphongtrong.setBackground(new Color(255, 255, 255, 200));
        pnl_chuthichphongtrong.setBounds(599, 574, 32, 26);
        contentPane.add(pnl_chuthichphongtrong);
        pnl_chuthichphongtrong.setLayout(null);
          
        testbutton.Buttontest btnthuephong = new testbutton.Buttontest();
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(128, 128, 128, 150));
        btnthuephong.setBounds(230, 70, 239, 87);
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
        btndatdichvu.setBounds(465, 70, 232, 87);
		contentPane.add(btndatdichvu);
		btndatdichvu.setLayout(null);
		
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
        btnkhachhang.setBounds(695, 70, 232, 87);
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
        btnthongke.setBounds(925, 70, 232, 87);
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
