package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JScrollPane;


import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import DAO.*;

import Entity.*;
import connectDB.connectDB;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.GridLayout;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class GD_DatDichVu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClock;
	private Timer timer;

	private JTable table;
	private JComboBox<String> comboBox_chonPhong;
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
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DatDichVu frame = new GD_DatDichVu();
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
	public GD_DatDichVu() {
		initComponents();
		setBackground(Color.WHITE);
		setTitle("Đặt Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		
		connectDB.getInstance().connect();
		loadData();
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

        timer = new Timer(0, this);
        timer.start();
		
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
        btndatphong1.setBackground(new Color(0,0,0,150));
        btndatphong1.setBounds(0, 70, 199, 87);
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
        btnthuephong.setBounds(195, 70, 196, 87);
		contentPane.add(btnthuephong);
		btnthuephong.setLayout(null);
		
        testbutton.Buttontest btndatdichvu = new testbutton.Buttontest();
        btndatdichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
        btndatdichvu.setBorder(null);
        btndatdichvu.setText("Đặt Dịch Vụ");
        btndatdichvu.setForeground(Color.WHITE);
        btndatdichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndatdichvu.setBackground(new Color(128,128,128, 150));
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
		
		JPanel DangXuat = new JPanel();
		DangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		JButton jButton_1 = new JButton("Đăng Xuất");
		jButton_1.setBounds(990, 10, 150, 50);
		jButton_1.setFont(new Font("Tahoma ", Font.BOLD, 14));
		jButton_1.setBackground(new Color(255, 0, 0));
		jButton_1.setForeground(Color.WHITE);
		
			jButton_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
			jButton_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
			jButton_1.setContentAreaFilled(false);
			jButton_1.setFocusPainted(false);
			jButton_1.setOpaque(true);
			contentPane.add(jButton_1);
			
					jButton_1.addMouseListener(new MouseAdapter() {
					    @Override
					    public void mouseEntered(MouseEvent e) {
					        jButton_1.setBackground(Color.BLACK);
					    }
			
					    @Override
					    public void mouseExited(MouseEvent e) {
					        jButton_1.setBackground(new Color(255, 0, 0));
					    }
					});
					
							jButton_1.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e) {
							        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							            GD_Login lg = new GD_Login();
							            lg.setVisible(true);
							            lg.setLocationRelativeTo(null);
							            dispose();
							        }
							    }
							});
							
		JPanel Right_DatDichVu = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Right_DatDichVu.setBackground(new Color(255, 255, 255, 100));
		Right_DatDichVu.setBounds(462, 146, 699, 467);
		Right_DatDichVu.setOpaque(false);
		contentPane.add(Right_DatDichVu);
		Right_DatDichVu.setLayout(null);
		
		comboBox_chonPhong = new JComboBox<String>();
		comboBox_chonPhong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_chonPhong.setBackground(new Color(255, 255, 255));
		comboBox_chonPhong.setBounds(10, 48, 96, 28);
		Right_DatDichVu.add(comboBox_chonPhong);
		loadComBoBoxChonPhong();
		
		JLabel lblchonphong = new JLabel("Chọn Phòng");
		lblchonphong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblchonphong.setBounds(10, 10, 96, 28);
		Right_DatDichVu.add(lblchonphong);
		
		testbutton.Buttontest btnDatDV = new testbutton.Buttontest();
		btnDatDV.setText("Đặt Dịch Vụ");
		btnDatDV.setBackground(new Color(199, 56, 102));
		btnDatDV.setForeground(new Color(255, 255, 255));
		btnDatDV.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatDV.setBounds(527, 26, 150, 50);
		btnDatDV.setRippleColor(new Color(255, 255, 255));
		btnDatDV.setShadowColor(new Color(0,0,0));
		btnDatDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDatDVActionPerformed(e);
			}
		});
		Right_DatDichVu.add(btnDatDV);
		
		JScrollPane scrollPane_DSDVdadat = new JScrollPane();

		scrollPane_DSDVdadat.setBounds(0, 86, 699, 371);
		scrollPane_DSDVdadat.setBackground(new Color(255, 255, 255));

		scrollPane_DSDVdadat.setBounds(0, 86, 699, 381);

		Right_DatDichVu.add(scrollPane_DSDVdadat);
		
		table = new JTable();
		table.setBorder(null);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(255, 255, 255));
		scrollPane_DSDVdadat.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã DV");
		model.addColumn("Tên Dịch Vụ");
		model.addColumn("Đơn Giá");
		model.addColumn("Số Lượng");
//		model.addColumn("Thêm");
//		model.addColumn("Bớt");
		model.addColumn("Xóa");

		table.setModel(model);
		table.getColumnModel().getColumn(4).setCellRenderer(new XoaRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new XoaEditor(table));
        
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
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/Imgs/370.png")));
		lblNewLabel.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblNewLabel);
		
	}

	protected void btnDatDVActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         GD_Main_NV mainnv=new GD_Main_NV();
         mainnv.setVisible(true);
    }
	
	@Override
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
    public void loadComBoBoxChonPhong() {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Karaoke4T";
        String username = "sa";
        String password = "123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Phong";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String columnName = resultSet.getString("maPhong");
                comboBox_chonPhong.addItem(columnName);
              
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	private void loadData() {
		QLDV_DAO ds = new QLDV_DAO();
		ArrayList<DichVu> listDV = ds.docbang();
		draw(listDV);
	}
	
	private void draw(ArrayList<DichVu> listdv) {
		JPanel Left_QLDV = new JPanel();
		Left_QLDV.setBorder(null);
		Left_QLDV.setBackground(new Color(255, 255, 255, 100));
		Left_QLDV.setBounds(0, 146, 464, 467);
		contentPane.add(Left_QLDV);
		Left_QLDV.setLayout(null);
		
		JScrollPane scrollPane_DSDV = new JScrollPane();
		scrollPane_DSDV.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_DSDV.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_DSDV.setBounds(0, 0, 464, 465);
		scrollPane_DSDV.setBackground(new Color(255, 255, 255, 0));
		Left_QLDV.add(scrollPane_DSDV);
		
		JPanel panel_dsdv = new JPanel();
		panel_dsdv.setBackground(new Color(255, 255, 255));
		scrollPane_DSDV.setViewportView(panel_dsdv);
		panel_dsdv.setLayout(new GridLayout(0, 3, 0, 0));
    	for(DichVu dv : listdv) {
    		//load label cha
    		JPanel pnl_dichvu = new JPanel();
    		pnl_dichvu.setBackground(new Color(255, 255, 255));
    		pnl_dichvu.setLayout(null);
    		pnl_dichvu.setPreferredSize(new Dimension(150,150));
    		pnl_dichvu.setBorder(LineBorder.createBlackLineBorder());
    		panel_dsdv.add(pnl_dichvu);


    		
    		//load label gia
    		JLabel lbl_price = new JLabel(dv.getGiaDichVu() + "/1 cái");
    		lbl_price.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_price.setFont(new Font("Tahoma", Font.BOLD, 11));
//    		lbl_price.setBorder(new LineBorder(new Color(0, 0, 0)));
    		lbl_price.setBounds(0, 115, 150, 35);
    		pnl_dichvu.add(lbl_price);
    		
    		//load ten dich vu
    		JLabel lbl_name = new JLabel(dv.getTenDichVu());
    		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 13));
    		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_name.setBounds(0, 98, 150, 35);
    		pnl_dichvu.add(lbl_name);
    		
    		//load hinh anh
    		JLabel lbl_hinhanh = new JLabel("");
    		lbl_hinhanh.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/food.png")));
    		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_hinhanh.setBounds(0, 0, 150, 150);
    		pnl_dichvu.add(lbl_hinhanh);
    		pnl_dichvu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					String ma = dv.getMaDichVu();
					updateTable(ma);
				}

			}); 		
		}
	}
	
	
	private void updateTable(String maDV) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        QLDV_DAO dichVuDAO = new QLDV_DAO();
        DichVu dichVu = dichVuDAO.layDichVuTheoMa(maDV);

        if (dichVu != null) {
            Object[] rowData = {dichVu.getMaDichVu(), dichVu.getTenDichVu(), dichVu.getGiaDichVu()};
            model.addRow(rowData);
        }
	}
	static class XoaRenderer extends JButton implements TableCellRenderer {
        public XoaRenderer() {
            setOpaque(true);
            setIcon(new ImageIcon("delete.png"));
            setToolTipText("Xóa");
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    static class XoaEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public XoaEditor(JTable table) {
            super(new JCheckBox());
            this.table = table;
            button = new JButton(new ImageIcon("delete.png"));
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
		
}