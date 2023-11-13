package GiaoDien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import DAO.QLKH_DAO;
import DAO.QLNV_DAO;
import DAO.ThongKeHoaDon_DAO;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.ThongKeHoaDon;
import connectDB.connectDB;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JComboBox;

public class GD_ThongKeHoaDon extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textFieldTongSoKhachHang;
	private JTextField textFieldTongDoanhThu;
	
	private int selectedValueNgay = 0;
	private String selectedValueThang = null;
	private int selectedValueNam = 0;
	private String thang [] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private JComboBox comboBoxThang = new JComboBox<>(thang);
	
//	private JComboBox comboBoxThang;
	ThongKeHoaDon_DAO dstk = new ThongKeHoaDon_DAO();
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
            java.util.logging.Logger.getLogger(GD_ThongKeHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThongKeHoaDon frame = new GD_ThongKeHoaDon();
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
	public GD_ThongKeHoaDon() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Thống Kê Hóa Đơn");
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
        
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_ThongKeHoaDon.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
        JLabel lblquanly = new JLabel("QL:");
		lblquanly.setForeground(Color.WHITE);
		lblquanly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblquanly.setBounds(878, -20, 232, 80);
		contentPane.add(lblquanly);
		
		JLabel lbltenql = new JLabel("Nguyễn Văn A");
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
		
		//
        testbutton.Buttontest btnphonghat = new testbutton.Buttontest();
        btnphonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhongHat gdphong = new GD_PhongHat();
				gdphong.setVisible(true);
				dispose();
			}
		});
        btnphonghat.setBorder(null);
        btnphonghat.setText("Phòng Hát");
        btnphonghat.setForeground(Color.WHITE);
        btnphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnphonghat.setBackground(new Color(0, 0, 0, 150));
        btnphonghat.setBounds(0, 70, 232, 87);
		contentPane.add(btnphonghat);
		btnphonghat.setLayout(null);
		
		testbutton.Buttontest btndichvu = new testbutton.Buttontest();
        btndichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QLDichVu gdqldv = new GD_QLDichVu();
				gdqldv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqldv.setVisible(true);
				dispose();
			}
		});
        btndichvu.setBorder(null);
        btndichvu.setText("Dịch Vụ");
        btndichvu.setForeground(Color.WHITE);
        btndichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndichvu.setBackground(new Color(0, 0, 0, 150));
        btndichvu.setBounds(230, 70, 239, 87);
		contentPane.add(btndichvu);
		btndichvu.setLayout(null);
		
        testbutton.Buttontest btnnhanvien = new testbutton.Buttontest();
        btnnhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_QLNhanVien gdqlnv = new GD_QLNhanVien();
				gdqlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdqlnv.setVisible(true);
				dispose();
			}
		});
        btnnhanvien.setBorder(null);
        btnnhanvien.setText("Nhân Viên");
        btnnhanvien.setForeground(Color.WHITE);
        btnnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnnhanvien.setBackground(new Color(0, 0, 0, 150));
        btnnhanvien.setBounds(465, 70, 232, 87);
		contentPane.add(btnnhanvien);
		btnnhanvien.setLayout(null);
		
        testbutton.Buttontest btntaikhoan = new testbutton.Buttontest();
        btntaikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_TaiKhoan taikhoan = new GD_TaiKhoan();
				taikhoan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				taikhoan.setVisible(true);
				dispose();
			}
		});
        btntaikhoan.setBorder(null);
        btntaikhoan.setText("Tài Khoản");
        btntaikhoan.setForeground(Color.WHITE);
        btntaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntaikhoan.setBackground(new Color(0,0,0, 150));
        btntaikhoan.setBounds(695, 70, 232, 87);
		contentPane.add(btntaikhoan);
		btntaikhoan.setLayout(null);
		
        testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
        btnthongke.setBorder(null);
        btnthongke.setText("Thống Kê");
        btnthongke.setForeground(Color.WHITE);
        btnthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthongke.setBackground(new Color(128,128,128, 150));
        btnthongke.setBounds(925, 70, 232, 87);
		contentPane.add(btnthongke);
		btnthongke.setLayout(null);
		
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		panel.setBounds(-2, 151, 1173, 223);
		panel.setBackground(new Color(255, 255, 255,200));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Theo Ngày");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 11, 173, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Theo Tháng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(437, 15, 73, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Theo Năm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(595, 18, 113, 14);
		panel.add(lblNewLabel_1_2);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(595, 47, 50, 20);
		yearChooser.setOpaque(false);
		panel.add(yearChooser);
		
		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		
		panel_1.setOpaque(false);
		panel_1.setBounds(10, 30, 375, 182);
		panel.add(panel_1);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(10, 39, 289, 133);
		dayChooser.setOpaque(false);
		panel_1.add(dayChooser);
		
	    
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setBackground(new Color(194, 100, 154));
		btnThongKe.setBounds(778, 30, 142, 42);
		panel.add(btnThongKe);
		
		
		
		
        
		btnThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedValueNgay = dayChooser.getDay();
				selectedValueThang =  (String) comboBoxThang.getSelectedItem();
				selectedValueNam =  yearChooser.getYear();
				// TODO Auto-generated method stub
				
				// Lấy giá trị đã chọn từ JComboBox
		        System.out.print(selectedValueNgay + "\n");
		        
		        ThongKeHoaDon_DAO dstk = new ThongKeHoaDon_DAO();
				ArrayList<ThongKeHoaDon> ls = dstk.doctubangTheoThang(selectedValueNgay,selectedValueThang,selectedValueNam);
				for(ThongKeHoaDon s : ls) {
					
//					loadTable();
//					loadDanhSachThongKe(selectedValue);
					loadDataFromSQL(selectedValueNgay,selectedValueThang,selectedValueNam);
					loadTongDoanThu(selectedValueNgay,selectedValueThang,selectedValueNam);
					loadTongSoKhachHang(selectedValueNgay,selectedValueThang,selectedValueNam) ;
				}
				
			}
			
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng doanh thu");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(967, 19, 122, 21);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tổng khách hàng");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(967, 91, 122, 21);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldTongSoKhachHang = new JTextField();
		textFieldTongSoKhachHang.setColumns(10);
		textFieldTongSoKhachHang.setBounds(967, 112, 142, 28);
		panel.add(textFieldTongSoKhachHang);
		
		textFieldTongDoanhThu = new JTextField();
		textFieldTongDoanhThu.setColumns(10);
		textFieldTongDoanhThu.setBounds(967, 44, 142, 28);
		panel.add(textFieldTongDoanhThu);		
		
		
//		comboBoxThang = new JComboBox<>(thang);
		comboBoxThang.setBounds(437, 47, 83, 20);
		panel.add(comboBoxThang);

		
		//talbe
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 372, 1161, 290);
		// Set the component orientation to RIGHT_TO_LEFT
//		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("Mã hóa đơn");
		model.addColumn("Họ Tên Khách Hàng");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Ngày Lập");
		model.addColumn("Nhân Viên Lập");
		model.addColumn("Tổng Tiền");
		// Add data to the table
		//model.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
		table.setModel(model);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1161, 613);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/Imgs/370.png")));
 

		connectDB.getInstance().connect();
		loadTable();
//		updateTableData();
//		loadTongDoanThu();
//		loadTongSoKhachHang("11") ;
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
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         GD_Main_QL mainql=new GD_Main_QL();
         mainql.setVisible(true);
    }
    
    
    private void updateTableData() {
		ThongKeHoaDon_DAO dstk = new ThongKeHoaDon_DAO();
		ArrayList<ThongKeHoaDon> ls = dstk.doctubang();
		for(ThongKeHoaDon s : ls) {
			
			String [] rowData = {s.getMaHD() + "",s.getTenKH() + "",s.getSDT() + "",s.getNgayLap() + "",s.getTenNV() + "",s.getTongTien() + ""};

			model.addRow(rowData);
			table.setModel(model);
		}
		
	}
    
    
    public void loadTongDoanThu(int ngay,String thang,int nam) {

		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "select sum(tongTien) as tongTien from HoaDon hd\r\n"
            		+ "inner join KhachHang kh\r\n"
            		+ "on hd.maKH = kh.maKH\r\n"
            		+ "where DAY(ngayLap) = ? and month(ngayLap) = ? and YEAR(ngayLap) = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ngay);
            statement.setString(2, thang);
            statement.setInt(3, nam);
            ResultSet resultSet = statement.executeQuery();

            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("tongTien");
                textFieldTongDoanhThu.setText(columnName);
               
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    
    public void loadTongSoKhachHang(int ngay,String thang,int nam) {
		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "select count(kh.maKH) as SoLuongKhachHang from HoaDon hd\r\n"
            		+ "inner join KhachHang kh\r\n"
            		+ "on hd.maKH = kh.maKH\r\n"
            		+ "where DAY(ngayLap) = ? and month(ngayLap) = ? and YEAR(ngayLap) = ?";
            
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ngay);
            statement.setString(2, thang);
            statement.setInt(3, nam);
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("SoLuongKhachHang");
                textFieldTongSoKhachHang.setText(columnName);
               
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    public void loadTable() {
    	 try {
             // Kết nối đến cơ sở dữ liệu
             Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T", "sa", "123");
             
             // Sử dụng PreparedStatement để có thể truyền tham số
             String sql = "select maHD, kh.tenKH, kh.SDT, ngayLap, tenNV, tongTien from HoaDon h " +
                          "inner join KhachHang kh on h.maKH = kh.maKH " +
                          "inner join NhanVien nv on h.maNV = nv.maNV ";
             try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                 // Thiết lập giá trị cho tham số
                 // Thực hiện truy vấn
                 try (ResultSet resultSet = preparedStatement.executeQuery()) {
                     // Xóa dữ liệu cũ trong tableModel
                     model.setRowCount(0);

                     // Thêm dữ liệu từ ResultSet vào tableModel
                     while (resultSet.next()) {
                         Object[] row = {
                                 resultSet.getString("maHD"),
                                 resultSet.getString("tenKH"),
                                 resultSet.getString("SDT"),
                                 resultSet.getString("ngayLap"),
                                 resultSet.getString("tenNV"),
                                 resultSet.getString("tongTien")
                                 // Thêm các cột khác nếu cần
                         };
                         model.addRow(row);
                     }
                 }
             }

             // Đóng tài nguyên
             connection.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
	}
    
    
    
    private void loadDataFromSQL(int ngay,String thang,int nam) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T", "sa", "123");
            
            // Sử dụng PreparedStatement để có thể truyền tham số
            String sql = "select maHD, kh.tenKH, kh.SDT, ngayLap, tenNV, tongTien from HoaDon h " +
                         "inner join KhachHang kh on h.maKH = kh.maKH " +
                         "inner join NhanVien nv on h.maNV = nv.maNV " +
                         "where DAY(ngayLap) = ? and month(ngayLap) = ? and YEAR(ngayLap) = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Thiết lập giá trị cho tham số
            	preparedStatement.setInt(1, ngay);
                preparedStatement.setString(2, thang);
                preparedStatement.setInt(3, nam);
                // Thực hiện truy vấn
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Xóa dữ liệu cũ trong tableModel
                    model.setRowCount(0);

                    // Thêm dữ liệu từ ResultSet vào tableModel
                    while (resultSet.next()) {
                        Object[] row = {
                                resultSet.getString("maHD"),
                                resultSet.getString("tenKH"),
                                resultSet.getString("SDT"),
                                resultSet.getString("ngayLap"),
                                resultSet.getString("tenNV"),
                                resultSet.getString("tongTien")
                                // Thêm các cột khác nếu cần
                        };
                        model.addRow(row);
                    }
                }
            }

            // Đóng tài nguyên
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
