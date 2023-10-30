package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
public class QuanLyKhachHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang frame = new QuanLyKhachHang();
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
	public QuanLyKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		JPanel datphong = new JPanel();
		datphong.setBounds(0, 70, 232, 80);
		contentPane.setLayout(null);
		
		
//		Clock ---------------------------------
		JPanel box_clock = new JPanel();
		box_clock.setBounds(34, 10, 260, 50);
        box_clock.setBorder(new LineBorder(Color.BLACK));
        contentPane.add(box_clock);
        box_clock.setLayout(null);

        lblClock = new JLabel();
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblClock.setBounds(0, 0, 260, 50);
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.WHITE);
        box_clock.add(lblClock);

        timer = new Timer(0, this);
        timer.start();
		
//         -------------------------------
		JLabel lblquanly = new JLabel("NV:");
		lblquanly.setBounds(878, -20, 232, 80);
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn C");
		lbltenql.setBounds(833, 6, 232, 80);
		lbltenql.setForeground(Color.WHITE);
		lbltenql.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		
		datphong.setBorder(null);
		datphong.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(datphong);
		datphong.setLayout(null);
		
		JLabel lbldatphong = new JLabel("Đặt Phòng");
		lbldatphong.setForeground(Color.WHITE);
		lbldatphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldatphong.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatphong.setBounds(0, 0, 232, 80);
		datphong.add(lbldatphong);
		
		JPanel thuephong = new JPanel();
		thuephong.setBounds(229, 70, 232, 80);
		thuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thuephong.setLayout(null);
		thuephong.setBorder(null);
		thuephong.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(thuephong);
		
		JLabel lblthuephong = new JLabel("Thuê Phòng");
		lblthuephong.setHorizontalAlignment(SwingConstants.CENTER);
		lblthuephong.setForeground(Color.WHITE);
		lblthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthuephong.setBounds(0, 0, 232, 80);
		thuephong.add(lblthuephong);
		
		JPanel datdichvu = new JPanel();
		datdichvu.setBounds(462, 70, 232, 80);
		datdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		datdichvu.setLayout(null);
		datdichvu.setBorder(null);
		datdichvu.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(datdichvu);
		
		JLabel lbltdatdichvu = new JLabel("Đặt Dịch Vụ");
		lbltdatdichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbltdatdichvu.setForeground(Color.WHITE);
		lbltdatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltdatdichvu.setBounds(0, 0, 232, 80);
		datdichvu.add(lbltdatdichvu);
		
		JPanel khachhang = new JPanel();
		khachhang.setBounds(695, 70, 232, 80);
		khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		khachhang.setLayout(null);
		khachhang.setBorder(null);
		khachhang.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(khachhang);
		
		JLabel lbltkhachhang = new JLabel("Khách Hàng");
		lbltkhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lbltkhachhang.setForeground(Color.WHITE);
		lbltkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltkhachhang.setBounds(0, 0, 232, 80);
		khachhang.add(lbltkhachhang);
		
		JPanel thongke = new JPanel();
		thongke.setBounds(928, 70, 233, 80);
		thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		thongke.setLayout(null);
		thongke.setBorder(null);
		thongke.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(thongke);
		
		JLabel lblthongke = new JLabel("Thống Kê");
		lblthongke.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongke.setForeground(Color.WHITE);
		
		
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthongke.setBounds(0, 0, 232, 80);
		thongke.add(lblthongke);
		
		JPanel panel = new JPanel();
		panel.setBounds(-2, 151, 1173, 172);
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255,150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập Họ Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 10, 159, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(31, 90, 145, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(296, 10, 135, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số CMND");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(296, 90, 92, 23);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa Chỉ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(520, 91, 55, 20);
		panel.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(31, 37, 202, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		//rad button
		JLabel lblNewLabel_1_5 = new JLabel("Nam");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(561, 37, 33, 23);
		panel.add(lblNewLabel_1_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBackground(new Color(192, 192, 192));
		rdbtnNewRadioButton.setBounds(520, 37, 21, 23);
		rdbtnNewRadioButton.setContentAreaFilled(false);
		rdbtnNewRadioButton.setFocusPainted(false);
		
	
		JLabel lblNewLabel_1_6 = new JLabel("Nữ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(656, 37, 33, 23);
		panel.add(lblNewLabel_1_6);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		panel.add(rdbtnNewRadioButton);
		//radbuton//
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 123, 202, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(296, 37, 164, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(296, 123, 164, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(520, 121, 241, 27);
		panel.add(textField_4);
		
		//button them
		JButton btnthem = new JButton("Thêm");
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setForeground(SystemColor.text);
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(822, 24, 128, 48);
		btnthem.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(90,167,167)), 1, true));
		btnthem.setContentAreaFilled(false);
		btnthem.setFocusPainted(false);
		btnthem.setOpaque(true);
		btnthem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnthem.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnthem.setBackground(new Color(90, 167, 167));
            }
        });
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnthem);
		
		
		//button xoa
		JButton btnxoa = new JButton("Xóa");
		btnxoa.setForeground(SystemColor.text);
		btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(822, 100, 128, 48);
		btnxoa.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(254, 122, 21)), 1, true));
		btnxoa.setContentAreaFilled(false);
		btnxoa.setFocusPainted(false);
		btnxoa.setOpaque(true);
		btnxoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnxoa.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnxoa.setBackground(new Color(254, 122, 21));
            }
        });
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnxoa);
		
		//button sua
		JButton btnsua = new JButton("Sửa");
		btnsua.setForeground(SystemColor.text);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(1009, 24, 128, 48);
		btnsua.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(226, 211, 107)), 1, true));
		btnsua.setContentAreaFilled(false);
		btnsua.setFocusPainted(false);
		btnsua.setOpaque(true);
		btnsua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnsua.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnsua.setBackground(new Color(226, 211, 107));
            }
        });
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnsua);
		
		//button lammoi
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setForeground(SystemColor.text);
		btnLmMi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLmMi.setBackground(new Color(51, 83, 158));
		btnLmMi.setBounds(1010, 100, 128, 48);
		btnLmMi.setBorder(BorderFactory.createLineBorder(Color.getColor(null, new Color(51, 83, 158)), 1, true));
		btnLmMi.setContentAreaFilled(false);
		btnLmMi.setFocusPainted(false);
		btnLmMi.setOpaque(true);
		btnLmMi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnLmMi.setBackground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnLmMi.setBackground(new Color(51, 83, 158));
            }
        });
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnLmMi);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setContentAreaFilled(false);
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(629, 39, 21, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		//talbe
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 323, 1161, 290);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã KH");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Số CMND");
		model.addColumn("Địa chỉ");
		// Add data to the table
		//model.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
		table.setModel(model);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1161, 613);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/Imgs/370.png")));

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
