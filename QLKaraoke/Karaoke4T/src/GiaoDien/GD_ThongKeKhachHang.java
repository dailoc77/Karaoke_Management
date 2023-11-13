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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.swing.JComboBox;
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

import DAO.ThongKeHoaDon_DAO;
import DAO.ThongKeKhachHang_DAO;
import Entity.ThongKeHoaDon;
import Entity.ThongKeKhachHang;
import connectDB.connectDB;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
public class GD_ThongKeKhachHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	private JTextField textFieldTongKhachHang;
	
	private int selectedValueNgay = 0;
	private String selectedValueThang = null;
	private int selectedValueNam = 0;
	private String thang [] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private JComboBox comboBoxThang = new JComboBox<>(thang);
	
//	private JDayChooser dayChooser = new JDayChooser();
//	private JYearChooser yearChooser = new JYearChooser();
	
	ThongKeKhachHang_DAO dstk = new ThongKeKhachHang_DAO();
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
            java.util.logging.Logger.getLogger(GD_ThongKeKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_ThongKeKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThongKeKhachHang frame = new GD_ThongKeKhachHang();
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
	public GD_ThongKeKhachHang() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Thống Kê Khách Hàng");
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
				GD_TraPhong gdtraphong = new GD_TraPhong();
				gdtraphong.setVisible(true);
				dispose();
			}
		});
        btntstTrPhng.setBorder(null);
        btntstTrPhng.setText("Trả Phòng");
        btntstTrPhng.setForeground(Color.WHITE);
        btntstTrPhng.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntstTrPhng.setBackground(new Color(0,0,0, 150));
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
			}
		});
        btnthongke.setBorder(null);
        btnthongke.setText("Thống Kê");
        btnthongke.setForeground(Color.WHITE);
        btnthongke.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthongke.setBackground(new Color(128,128,128, 150));
        btnthongke.setBounds(963, 70, 196, 87);
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
		lblNewLabel_1.setBounds(28, 7, 173, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Theo Tháng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(437, 14, 73, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Theo Năm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(595, 20, 113, 14);
		panel.add(lblNewLabel_1_2);
		
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tổng khách hàng");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(980, 15, 122, 21);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldTongKhachHang = new JTextField();
		textFieldTongKhachHang.setColumns(10);
		textFieldTongKhachHang.setBounds(978, 47, 142, 28);
		panel.add(textFieldTongKhachHang);
		
//		comboBoxThang = new JComboBox();
		comboBoxThang.setBounds(447, 46, 63, 26);
		panel.add(comboBoxThang);
		
		ButtonGroup bg = new ButtonGroup();
		
		
		
		JPanel panel_1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
			
			panel_1.setOpaque(false);
			panel_1.setBounds(28, 30, 370, 182);
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
			
			JYearChooser yearChooser = new JYearChooser();
			yearChooser.setBounds(605, 45, 48, 20);
			panel.add(yearChooser);
		
			btnThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectedValueNgay = dayChooser.getDay();
				selectedValueThang =  (String) comboBoxThang.getSelectedItem();
				selectedValueNam  = yearChooser.getYear();
				System.out.print(selectedValueNgay + "\n");		
				System.out.print(selectedValueThang + "\n");
				System.out.print(selectedValueNam + "\n");
				
						        
		        ThongKeKhachHang_DAO dstk = new ThongKeKhachHang_DAO();
				ArrayList<ThongKeKhachHang> ls = dstk.doctubangTheoThang(selectedValueNgay, selectedValueThang, selectedValueNam);
				for(ThongKeKhachHang s : ls) {
					


					loadDataFromSQL(selectedValueNgay,selectedValueThang,selectedValueNam);
					loadTongSoKhachHang(selectedValueNgay,selectedValueThang,selectedValueNam);
				}
			}
		});
		
		//talbe
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 372, 1161, 241);
		// Set the component orientation to RIGHT_TO_LEFT
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Họ Tên Khách Hàng");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Số Căn Cước");
		model.addColumn("Địa chỉ");
		model.addColumn("Thời gian nhận phòng");
		// Add data to the table
		//model.addRow(new Object[]{"Data 1", "Data 2", "Data 3"});
		table.setModel(model);
		
//		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
//		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1161, 613);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/Imgs/370.png")));
	
		connectDB.getInstance().connect();
		loadTable();
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
         GD_Main_NV mainnv=new GD_Main_NV();
         mainnv.setVisible(true);
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
	
	

    public void loadTable() {
    	 try {
             // Kết nối đến cơ sở dữ liệu
             Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T", "sa", "123");
             
             // Sử dụng PreparedStatement để có thể truyền tham số
             String sql = "select  kh.maKH,tenKH,SDT,CMND,diaChi,thoiGianNhanPhong from PhieuDatPhong p\r\n"
             		+ "inner join KhachHang kh\r\n"
             		+ "on p.maKH = kh.maKH";
             try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                 // Thiết lập giá trị cho tham số
                 // Thực hiện truy vấn
                 try (ResultSet resultSet = preparedStatement.executeQuery()) {
                     // Xóa dữ liệu cũ trong tableModel
                     model.setRowCount(0);

                     // Thêm dữ liệu từ ResultSet vào tableModel
                     while (resultSet.next()) {
                         Object[] row = {
                                 resultSet.getString("maKH"),
                                 resultSet.getString("tenKH"),
                                 resultSet.getString("SDT"),
                                 resultSet.getString("CMND"),
                                 resultSet.getString("diaChi"),
                                 resultSet.getString("thoiGianNhanPhong")
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
    
    

    public void loadTongSoKhachHang(int ngay,String thang,int nam) {
		// Thông tin kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, username, password);

            // Truy vấn SQL để lấy dữ liệu
            String sql = "select COUNT(kh.maKH) as SoLuongKhachHang from PhieuDatPhong p\r\n"
            		+ "inner join KhachHang kh\r\n"
            		+ "on p.maKH = kh.maKH\r\n"
            		+ "where DAY(thoiGianNhanPhong) = ? and MONTH(thoiGianNhanPhong) = ? and YEAR(thoiGianNhanPhong) = ?";
            
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ngay);
            statement.setString(2, thang);
            statement.setInt(3, nam);
            ResultSet resultSet = statement.executeQuery();
            // Lặp qua các dòng kết quả và thêm vào JComboBox
            while (resultSet.next()) {
                String columnName = resultSet.getString("SoLuongKhachHang");
                textFieldTongKhachHang.setText(columnName);
               
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
    
    

    private void loadDataFromSQL(int ngay,String thang,int nam) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Karaoke4T", "sa", "123");
            
            // Sử dụng PreparedStatement để có thể truyền tham số
            String sql = "select kh.maKH,tenKH,SDT,CMND,diaChi,thoiGianNhanPhong\r\n"
            		+ "from PhieuDatPhong p\r\n"
            		+ "inner join KhachHang kh\r\n"
            		+ "on p.maKH = kh.maKH\r\n"
            		+ "where Day(thoiGianNhanPhong) = ? and month(thoiGianNhanPhong) = ? and YEAR(thoiGianNhanPhong) = ?";
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
                                resultSet.getString("maKH"),
                                resultSet.getString("tenKH"),
                                resultSet.getString("SDT"),
                                resultSet.getString("CMND"),
                                resultSet.getString("diaChi"),
                                resultSet.getString("thoiGianNhanPhong")
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
