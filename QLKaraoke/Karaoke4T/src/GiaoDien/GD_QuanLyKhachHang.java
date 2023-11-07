package GiaoDien;


import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Timer;


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
import DAO.*;
import Entity.*;
import connectDB.*;
import javax.swing.JScrollBar;
public class GD_QuanLyKhachHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txtmakh;
	private JTextField txtsdt;
	private JTextField txtcmnd;
	private JTextField txtdc;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	QLKH_DAO dskh = new QLKH_DAO();
	
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
            java.util.logging.Logger.getLogger(GD_QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_QuanLyKhachHang frame = new GD_QuanLyKhachHang();
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
	public GD_QuanLyKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 650);
		setTitle("Giao Diện Khách Hàng");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 70, 232, 80);
		contentPane.setLayout(null);
		

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
		lblavatar.setIcon(new ImageIcon(GD_Main_QL.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
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
		
// Thanh Menu
        
        testbutton.Buttontest btndatphong1 = new testbutton.Buttontest();
        btndatphong1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatPhong gddatphong = new GD_DatPhong();
				gddatphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddatphong.setVisible(true);
				dispose();
			}
		});
        btndatphong1.setBorder(null);
        btndatphong1.setText("Đặt Phòng");
        btndatphong1.setForeground(Color.WHITE);
        btndatphong1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatphong1.setBackground(new Color(0,0,0, 150));
        btndatphong1.setBounds(0, 70, 185, 87);
		contentPane.add(btndatphong1);
		btndatphong1.setLayout(null);
		
		testbutton.Buttontest btnthuephong = new testbutton.Buttontest();
        btnthuephong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThuePhong gdthuephong = new GD_ThuePhong();
				gdthuephong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdthuephong.setVisible(true);
				dispose();
			}
		});
        btnthuephong.setBorder(null);
        btnthuephong.setText("Thuê Phòng");
        btnthuephong.setForeground(Color.WHITE);
        btnthuephong.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnthuephong.setBackground(new Color(0, 0, 0, 150));
        btnthuephong.setBounds(195, 70, 185, 87);
		contentPane.add(btnthuephong);
		btnthuephong.setLayout(null);
		
        testbutton.Buttontest btndatdichvu = new testbutton.Buttontest();
        btndatdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_DatDichVu gddatdv = new GD_DatDichVu();
				gddatdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gddatdv.setVisible(true);
				dispose();
			}
		});
        btndatdichvu.setBorder(null);
        btndatdichvu.setText("Đặt Dịch Vụ");
        btndatdichvu.setForeground(Color.WHITE);
        btndatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatdichvu.setBackground(new Color(0, 0, 0, 150));
        btndatdichvu.setBounds(390, 70, 185, 87);
		contentPane.add(btndatdichvu);
		btndatdichvu.setLayout(null);
		
		testbutton.Buttontest btntraphong = new testbutton.Buttontest();
		btntraphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_TraPhong gdtraphong = new GD_TraPhong();
				gdtraphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtraphong.setVisible(true);
				dispose();
			}
		});
		btntraphong.setBorder(null);
		btntraphong.setText("Trả Phòng");
		btntraphong.setForeground(Color.WHITE);
		btntraphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btntraphong.setBackground(new Color(0,0,0, 150));
		btntraphong.setBounds(585, 70, 185, 87);
		contentPane.add(btntraphong);
		btntraphong.setLayout(null);
		
        testbutton.Buttontest btnkhachhang = new testbutton.Buttontest();
        btnkhachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
        btnkhachhang.setBorder(null);
        btnkhachhang.setText("Khách Hàng");
        btnkhachhang.setForeground(Color.WHITE);
        btnkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnkhachhang.setBackground(new Color(128,128,128, 150));
        btnkhachhang.setBounds(777, 70, 185, 87);
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
        btnthongke.setBounds(972, 70, 185, 87);
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
		panel.setBounds(-2, 151, 1173, 172);
		panel.setBackground(new Color(255, 255, 255,200));
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
		
		txtten = new JTextField();
		txtten.setBounds(31, 37, 202, 27);
		panel.add(txtten);
		txtten.setColumns(10);
		
		//rad button
		JRadioButton rdbtnNAM = new JRadioButton("Nam");
		rdbtnNAM.setBounds(520, 37, 109, 23);
		rdbtnNAM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNAM.setOpaque(false);
		rdbtnNAM.setContentAreaFilled(false);
		rdbtnNAM.setFocusPainted(false);
		panel.add(rdbtnNAM);
	
		
		JRadioButton rdbtnNU = new JRadioButton("Nữ");
		rdbtnNU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNU.setBounds(656, 38, 109, 23);
		rdbtnNU.setOpaque(false);
		panel.add(rdbtnNU);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNAM);
		bg.add(rdbtnNU);
		panel.add(rdbtnNAM);
		panel.add(rdbtnNU);
		//radbuton//
		
		txtmakh = new JTextField();
		txtmakh.setColumns(10);
		txtmakh.setBounds(31, 123, 202, 27);
		panel.add(txtmakh);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(296, 37, 164, 27);
		panel.add(txtsdt);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(296, 123, 164, 27);
		panel.add(txtcmnd);
		
		txtdc = new JTextField();
		txtdc.setColumns(10);
		txtdc.setBounds(520, 121, 241, 27);
		panel.add(txtdc);
		
		//button them
		testbutton.Buttontest btnthem = new testbutton.Buttontest();
		btnthem.setText("Thêm");
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setForeground(SystemColor.text);
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		btnthem.setBounds(822, 24, 128, 48);

		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed(e);
			}
		});
		panel.add(btnthem);
		
		
		//button xoa
		testbutton.Buttontest btnxoa = new testbutton.Buttontest();
		btnxoa.setText("Xóa");
		btnxoa.setForeground(SystemColor.text);
		btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(822, 109, 128, 48);
		btnxoa.setRippleColor(new Color(255, 255, 255));
		btnxoa.setShadowColor(new Color(0,0,0));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
			}
		});
		panel.add(btnxoa);
		
		//button sua
		testbutton.Buttontest btnsua = new testbutton.Buttontest();
		btnsua.setText("Sửa");
		btnsua.setForeground(SystemColor.text);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(1009, 24, 128, 48);
		btnsua.setRippleColor(new Color(255, 255, 255));
		btnsua.setShadowColor(new Color(0,0,0));
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsuaActionPerformed(e);
			}
		});
		panel.add(btnsua);
		
		//button lammoi
		testbutton.Buttontest btnlammoi = new testbutton.Buttontest();
	    btnlammoi.setText("Làm mới");
		btnlammoi.setForeground(SystemColor.text);
		btnlammoi.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnlammoi.setBackground(new Color(51, 83, 158));
		btnlammoi.setBounds(1010, 109, 128, 48);
		btnlammoi.setRippleColor(new Color(255, 255, 255));
		btnlammoi.setShadowColor(new Color(0,0,0));
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLmMiActionPerformed(e);
			}
		});
		panel.add(btnlammoi);
		
		
		//talbe
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 323, 1161, 290);
		// Set the component orientation to RIGHT_TO_LEFT
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("Mã KH");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Số CMND");
		model.addColumn("Địa chỉ");
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
		updateTableData();

	}
	
	
	protected void btnLmMiActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		lammoi();
	}

	protected void btnsuaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			KhachHang kh = reverSPFromTextField();
			if(dskh.update(kh)) {
				table.setValueAt(txtmakh.getText(), row, 1);
				table.setValueAt(txtten.getText(), row, 3);
				table.setValueAt(txtsdt.getText(), row, 4);
				table.setValueAt(txtcmnd.getText(), row, 5);
				table.setValueAt(txtdc.getText(), row, 6);
			}
			
		}
		table.setModel(model);
	}

	protected void btnxoaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row >= 0) {
			String makh = (String) table.getValueAt(row, 1);
			if(dskh.delete(makh)) {
				model.removeRow(row);
				lammoi();
			}
		}
		table.setModel(model);
	}

	protected void btnthemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		KhachHang kh = reverSPFromTextField();
		if(dskh.create(kh)) {
			Object [] rowData = {txtmakh.getText(), txtten.getText(), txtsdt.getText(), txtcmnd.getText(), txtdc.getText()};
			model.addRow(rowData);
		}
		table.setModel(model);
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
	
	private KhachHang reverSPFromTextField() {
		String makh = txtmakh.getText().toString();
		String ten = txtten.getText().toString();
		int sdt = Integer.parseInt(txtsdt.getText());
		int cccd = Integer.parseInt(txtcmnd.getText());
		String dch = txtdc.getText().toString();
		return new KhachHang(makh, "", ten, sdt, cccd, dch);
		
	}
	
	private void updateTableData() {
		QLKH_DAO ds = new QLKH_DAO();
		ArrayList<KhachHang> ls = ds.doctubang();
		for(KhachHang s : ls) {
			String [] rowData = {s.getMaKH(), s.getTenKH(), "", s.getSDT()+"", s.getCMND()+"", s.getDiaChi()};
			model.addRow(rowData);
			table.setModel(model);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtmakh.setText(table.getValueAt(row, 1).toString());
		
		txtten.setText(table.getValueAt(row, 3).toString());
		txtsdt.setText(table.getValueAt(row, 4).toString());
		txtcmnd.setText(table.getValueAt(row, 5).toString());
		txtdc.setText(table.getValueAt(row, 6).toString());
	}
	public void lammoi() {
		txtcmnd.setText("");
		txtten.setText("");
		txtmakh.setText("");
		txtsdt.setText("");
		txtdc.setText("");
		txtmakh.requestFocus();
	}
}
