package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GiaoDien.*;
import connectDB.connectDB;
import testbutton.Buttontest;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.border.LineBorder;

import DAO.QLDV_DAO;
import DAO.QLKH_DAO;
import DAO.QLPH_DAO;
import Entity.DichVu;
import Entity.KhachHang;
import Entity.Phong;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;


public class GD_QLDichVu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JLabel lblClock;
	private Timer timer;
	private JButton jButton;
	private JTextField txt_MaDV;
	private JTextField txt_tenDV;
	private JTextField txt_giaDV;
	private JTextField txt_soLuong;
	private QLDV_DAO ds_dv = new QLDV_DAO();
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
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QLDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_QLDichVu frame = new GD_QLDichVu();
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
	public GD_QLDichVu() {
//		initComponents();
		setBackground(Color.WHITE);
		setTitle("Giao Diện Quản Lý Dịch Vụ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//goi data
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
		
		JPanel left_QLDV = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		left_QLDV.setBackground(new Color(255, 255, 255, 180));
		left_QLDV.setBounds(0, 148, 294, 465);
		left_QLDV.setOpaque(false);
		contentPane.add(left_QLDV);
		left_QLDV.setLayout(null);
		
		txt_MaDV = new JTextField();
		txt_MaDV.setEnabled(false);
		txt_MaDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_MaDV.setBounds(10, 41, 150, 30);
		txt_MaDV.setBorder(null);
		left_QLDV.add(txt_MaDV);
		txt_MaDV.setColumns(10);
		
		JLabel lblmaDV = new JLabel("Mã Dịch Vụ");
		lblmaDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmaDV.setBounds(10, 27, 85, 13);
		left_QLDV.add(lblmaDV);
		
		txt_tenDV = new JTextField();
		txt_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tenDV.setColumns(10);
		txt_tenDV.setBorder(null);
		txt_tenDV.setBounds(10, 126, 230, 30);
		left_QLDV.add(txt_tenDV);
		
		JLabel lbltenDV = new JLabel("Tên Dịch Vụ");
		lbltenDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltenDV.setBounds(10, 112, 85, 13);
		left_QLDV.add(lbltenDV);
		
		txt_giaDV = new JTextField();
		txt_giaDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_giaDV.setColumns(10);
		txt_giaDV.setBorder(null);
		txt_giaDV.setBounds(10, 209, 230, 30);
		left_QLDV.add(txt_giaDV);
		
		JLabel lblgiaDV = new JLabel("Giá Dịch Vụ");
		lblgiaDV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblgiaDV.setBounds(10, 195, 85, 13);
		left_QLDV.add(lblgiaDV);
		
		txt_soLuong = new JTextField();
		txt_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_soLuong.setColumns(10);
		txt_soLuong.setBorder(null);
		txt_soLuong.setBounds(10, 299, 121, 30);
		left_QLDV.add(txt_soLuong);
		
		JLabel lblchuthich = new JLabel("Số lượng");
		lblchuthich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchuthich.setBounds(10, 285, 85, 13);
		left_QLDV.add(lblchuthich);
		
		testbutton.Buttontest btnthem = new testbutton.Buttontest();
		btnthem.setText("Thêm");
		btnthem.setForeground(new Color(255, 255, 255));
		btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnthem.setBackground(new Color(90, 167, 167));
		btnthem.setBounds(10, 359, 100, 48);
		btnthem.setRippleColor(new Color(255, 255, 255));
		btnthem.setShadowColor(new Color(0,0,0));
		
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthemActionPerformed(e);
			}
		});
		left_QLDV.add(btnthem);
		
		testbutton.Buttontest btnsua = new testbutton.Buttontest();
		btnsua.setText("Sửa");
		btnsua.setForeground(Color.WHITE);
		btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnsua.setBackground(new Color(226, 211, 107));
		btnsua.setBounds(164, 359, 100, 48);
		btnsua.setRippleColor(new Color(255, 255, 255));
		btnsua.setShadowColor(new Color(0,0,0));
		
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsuaActionPerformed(e);
			}
		});
		left_QLDV.add(btnsua);
		
		testbutton.Buttontest btnlammoi = new testbutton.Buttontest();
		btnlammoi.setText("Làm mới");
		btnlammoi.setForeground(Color.WHITE);
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnlammoi.setBackground(new Color(51, 83, 158));
		btnlammoi.setBounds(164, 413, 100, 48);
		btnlammoi.setRippleColor(new Color(255, 255, 255));
		btnlammoi.setShadowColor(new Color(0,0,0));
		
		btnlammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnlammoiActionPerformed(e);
			}
		});
		left_QLDV.add(btnlammoi);
		
		testbutton.Buttontest btnxoa = new testbutton.Buttontest();
		btnxoa.setText("Xóa");
		btnxoa.setForeground(Color.WHITE);
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnxoa.setBackground(new Color(254, 122, 21));
		btnxoa.setBounds(10, 413, 100, 48);
		btnxoa.setRippleColor(new Color(255, 255, 255));
		btnxoa.setShadowColor(new Color(0,0,0));
		
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnxoaActionPerformed(e);
				
			}
		});
		left_QLDV.add(btnxoa);
		
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
		
        testbutton.Buttontest btnphonghat = new testbutton.Buttontest();
        btnphonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_PhongHat gdphonghat = new GD_PhongHat();
				gdphonghat.setVisible(true);
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
			}
		});
        btndichvu.setBorder(null);
        btndichvu.setText("Dịch Vụ");
        btndichvu.setForeground(Color.WHITE);
        btndichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btndichvu.setBackground(new Color(128, 128,128, 150));
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
				GD_TaiKhoan gdtk = new GD_TaiKhoan();
				gdtk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtk.setVisible(true);
				dispose();
			}
		});
        btntaikhoan.setBorder(null);
        btntaikhoan.setText("Tài Khoản");
        btntaikhoan.setForeground(Color.WHITE);
        btntaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
        btntaikhoan.setBackground(new Color(0, 0, 0, 150));
        btntaikhoan.setBounds(695, 70, 232, 87);
		contentPane.add(btntaikhoan);
		btntaikhoan.setLayout(null);
		
        testbutton.Buttontest btnthongke = new testbutton.Buttontest();
        btnthongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GD_ThongKeHoaDon gdtk = new GD_ThongKeHoaDon();
				gdtk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gdtk.setVisible(true);
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
		
		JLabel lblavatar = new JLabel("");
		lblavatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblavatar.setIcon(new ImageIcon(GD_TaiKhoan.class.getResource("/Imgs/t1 1.png")));
		lblavatar.setBounds(90, -444, 1333, 957);
		contentPane.add(lblavatar);
	
		JLabel lblhinhnen = new JLabel("");
		lblhinhnen.setHorizontalAlignment(SwingConstants.CENTER);
		lblhinhnen.setIcon(new ImageIcon(GD_Main_NV.class.getResource("/Imgs/370.png")));
		lblhinhnen.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblhinhnen);
	}
	
	private DichVu reverSPFromTextField() {
		String maDV = txt_MaDV.getText();
		double giaDV = Double.parseDouble(txt_giaDV.getText());
		int soLuong = Integer.parseInt(txt_soLuong.getText());
		String tenDV = txt_tenDV.getText();
		DichVu d = new DichVu(maDV, giaDV, soLuong, tenDV);
		return d;
		
	}
	
	protected void btnxoaActionPerformed(ActionEvent e) {
		ds_dv.deleteDvbymaDV(txt_MaDV.getText());
//		refresh();
			
	}
	protected void btnlammoiActionPerformed(ActionEvent e) {
		refresh();
		
	}
	protected void btnsuaActionPerformed(ActionEvent e) {
		DichVu ph = reverSPFromTextField();
		ds_dv.update(ph);
		JOptionPane.showMessageDialog(null, "Sửa thông tin Phòng thành công!");
		loadData();
	}
	protected void btnthemActionPerformed(ActionEvent e) {
		QLDV_DAO dsdv = new QLDV_DAO();
		int maxMaDV = dsdv.getMaxMaDV();
	    
	    // Tăng mã dv lên 1 để có mã mới
		maxMaDV++;
	    
	    // Gán giá trị mới cho ô nhập liệu mã dv
	    txt_MaDV.setText("DV" + String.format("%03d", maxMaDV));
		DichVu dv = reverSPFromTextField();
		dsdv.themDichVu(dv);
		JOptionPane.showMessageDialog(this,"Thêm Dịch Vụ Thành Công");
		refresh();
	}
	
	public void refresh() {
		txt_MaDV.setText("");
		txt_giaDV.setText("");
		txt_soLuong.setText("");
		txt_tenDV.setText("");
		loadData();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
	
	private void loadData() {
		QLDV_DAO ds = new QLDV_DAO();
		ArrayList<DichVu> listDV = ds.docbang();
		draw(listDV);
	}
	
	private void draw(ArrayList<DichVu> listdv) {
		JPanel Right_QLDV = new JPanel();
		Right_QLDV.setBorder(null);
		Right_QLDV.setBackground(new Color(255, 255, 255, 150));
		Right_QLDV.setBounds(291, 148, 870, 465);
		contentPane.add(Right_QLDV);
		Right_QLDV.setLayout(null);
		
		JScrollPane scrollPane_DSDV = new JScrollPane();
		scrollPane_DSDV.setBounds(0, 0, 870, 465);
		scrollPane_DSDV.setBackground(new Color(255, 255, 255, 0));
		Right_QLDV.add(scrollPane_DSDV);
		
		JPanel panel_dsdv = new JPanel();
		panel_dsdv.setBackground(new Color(255, 255, 255));
		scrollPane_DSDV.setViewportView(panel_dsdv);
		panel_dsdv.setLayout(new GridLayout(0, 5, 10, 10));
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
    		lbl_price.setBounds(39, 115, 85, 35);
    		pnl_dichvu.add(lbl_price);
    		
    		//load ten dich vu
    		JLabel lbl_name = new JLabel(dv.getTenDichVu());
    		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 13));
    		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_name.setBounds(39, 98, 85, 35);
    		pnl_dichvu.add(lbl_name);
    		
    		//load hinh anh
    		JLabel lbl_hinhanh = new JLabel("");
    		lbl_hinhanh.setIcon(new ImageIcon(GD_QLDichVu.class.getResource("/Imgs/food.png")));
    		lbl_hinhanh.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl_hinhanh.setBounds(0, 0, 162, 121);
    		pnl_dichvu.add(lbl_hinhanh);
    		
    		pnl_dichvu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txt_MaDV.setText(dv.getMaDichVu());
					txt_tenDV.setText(dv.getTenDichVu());
					txt_giaDV.setText(dv.getGiaDichVu()+"");
					txt_soLuong.setText(dv.getSoLuongDichVu()+"");
				}
			});
    		
		}
    }
	
//	private void initComponents() {
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent evt) {
//                formWindowClosing(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 300, Short.MAX_VALUE)
//        );
//
//        pack();
//    }
//
//    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//         GD_Main_QL mainql=new GD_Main_QL();
//         mainql.setVisible(true);
//    }
	
	//dong ho
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
        
        String time = String.format("%02d:%02d:%02d %s  %02d/%02d/%04d", hour, minute, second, ampm, day, month, year);
        lblClock.setText(time);
    }
}

