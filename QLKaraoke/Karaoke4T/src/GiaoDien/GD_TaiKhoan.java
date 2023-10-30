package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import testbutton.Buttontest;


public class GD_TaiKhoan extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoTen, txtMaKH, txtDiaChi, txtTaiKhoan;
	private JTable table;
	DefaultTableModel model;
	private JLabel lblClock;
	private Timer timer;
	private testbutton.Buttontest btnthem, btnxoa, btnlammoi, btnsua;
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
            java.util.logging.Logger.getLogger(GD_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_TaiKhoan frame = new GD_TaiKhoan();
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
	public GD_TaiKhoan() {
		setBackground(Color.WHITE);
		setTitle("Giao Diện Tài Khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1175, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		
		JPanel phonghat = new JPanel();
		phonghat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		phonghat.setBorder(null);
		phonghat.setBackground(new Color(0, 0, 0, 150));
		phonghat.setBounds(0, 70, 232, 80);
		contentPane.add(phonghat);
		phonghat.setLayout(null);
		
		JLabel lblphonghat = new JLabel("Phòng Hát");
		lblphonghat.setForeground(Color.WHITE);
		lblphonghat.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblphonghat.setHorizontalAlignment(SwingConstants.CENTER);
		lblphonghat.setBounds(0, 0, 232, 80);
		phonghat.add(lblphonghat);
		
		JPanel dichvu = new JPanel();
		dichvu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dichvu.setLayout(null);
		dichvu.setBorder(null);
		dichvu.setBackground(new Color(0, 0, 0, 150));
		dichvu.setBounds(229, 70, 232, 80);
		contentPane.add(dichvu);
		
		JLabel lbldichvu = new JLabel("Dịch Vụ");
		lbldichvu.setHorizontalAlignment(SwingConstants.CENTER);
		lbldichvu.setForeground(Color.WHITE);
		lbldichvu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldichvu.setBounds(0, 0, 232, 80);
		dichvu.add(lbldichvu);
		
		JPanel nhanvien = new JPanel();
		nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		nhanvien.setLayout(null);
		nhanvien.setBorder(null);
		nhanvien.setBackground(new Color(0, 0, 0, 150));
		nhanvien.setBounds(462, 70, 232, 80);
		contentPane.add(nhanvien);
		
		JLabel lblnhanvien = new JLabel("Nhân Viên");
		lblnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnhanvien.setBounds(0, 0, 232, 80);
		nhanvien.add(lblnhanvien);
		
		JPanel taikhoan = new JPanel();
		taikhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		taikhoan.setLayout(null);
		taikhoan.setBorder(null);
		taikhoan.setBackground(new Color(0, 0, 0, 150));
		taikhoan.setBounds(695, 70, 232, 80);
		contentPane.add(taikhoan);
		
		JLabel lbltaikhoan = new JLabel("Tài Khoản");
		lbltaikhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lbltaikhoan.setForeground(Color.WHITE);
		lbltaikhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltaikhoan.setBounds(0, 0, 232, 80);
		taikhoan.add(lbltaikhoan);
		
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
		
		//panel bg mờ
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel.setBounds(-2, 151, 1173, 172);
		panel.setBackground(new Color(255, 255, 255,180));
		panel.setOpaque(false);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblhoten = new JLabel("Nhập Họ Tên");
		lblhoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblhoten.setBounds(31, 10, 159, 28);
		panel.add(lblhoten);
		txtHoTen = new JTextField();
		txtHoTen.setBounds(31, 37, 202, 27);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblmakh = new JLabel("Số Điện Thoại");
		lblmakh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmakh.setBounds(31, 90, 145, 23);
		panel.add(lblmakh);
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(31, 123, 202, 27);
		panel.add(txtMaKH);
		
		JLabel lbldiachi = new JLabel("Mật Khẩu");
		lbldiachi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldiachi.setBounds(520, 91, 145, 20);
		panel.add(lbldiachi);
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(520, 121, 241, 27);
		panel.add(txtDiaChi);
		
		JLabel lbltentk = new JLabel("Tên Tài Khoản");
		lbltentk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltentk.setBounds(520, 10, 159, 28);
		panel.add(lbltentk);
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(520, 37, 241, 27);
		panel.add(txtTaiKhoan);
		
		//button them
				btnthem = new testbutton.Buttontest();
				btnthem.setText("Thêm");
				btnthem.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnthem.setForeground(new Color(245,245,245));
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
				btnxoa = new testbutton.Buttontest();
				btnxoa.setText("Xóa");
				btnxoa.setForeground(SystemColor.text);
				btnxoa.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnxoa.setBackground(new Color(254, 122, 21));
				btnxoa.setRippleColor(new Color(255, 255, 255));
				btnxoa.setShadowColor(new Color(0,0,0));
				btnxoa.setBounds(822, 109, 128, 48);
				
				btnxoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnxoaActionPerformed(e);
					}
				});
				panel.add(btnxoa);
				
				//button sua
				btnsua = new testbutton.Buttontest();
				btnsua.setText("Sửa");
				btnsua.setForeground(SystemColor.text);
				btnsua.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnsua.setBackground(new Color(226, 211, 107));
				btnsua.setRippleColor(new Color(255, 255, 255));
				btnsua.setShadowColor(new Color(0,0,0));
				btnsua.setBounds(1009, 24, 128, 48);

				btnsua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnsuaActionPerformed(e);
					}
				});
				panel.add(btnsua);
				
				//button lammoi
				btnlammoi = new testbutton.Buttontest();
				btnlammoi.setText("Làm mới");
				btnlammoi.setForeground(SystemColor.text);
				btnlammoi.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnlammoi.setBackground(new Color(51, 83, 158));
				btnlammoi.setRippleColor(new Color(255, 255, 255));
				btnlammoi.setShadowColor(new Color(0,0,0));
				btnlammoi.setBounds(1009, 109, 128, 48);
				btnlammoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnlammoiActionPerformed(e);
					}
				});
				panel.add(btnlammoi);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 323, 1161, 290); // Adjust the position and size as needed
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Họ Tên");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tên Tài Khoản");
		model.addColumn("Mật Khẩu");
		// Add data to the table
		model.addRow(new Object[]{"1", "Nguyễn Văn A", "09999999", "aaabb@gmail.com", "aaaa"});
		model.addRow(new Object[]{"", "", "", "", ""});
		table.setModel(model);
		
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
		lblhinhnen.setIcon(new ImageIcon(GD_TaiKhoan.class.getResource("/Imgs/370.png")));
		lblhinhnen.setBounds(-95, -176, 1333, 957);
		contentPane.add(lblhinhnen);
		
		//button dang xuat
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
	}
	protected void btnlammoiActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void btnsuaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void btnxoaActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void btnthemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
            // Cập nhật thời gian
            updateClock();
        }
	}
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

